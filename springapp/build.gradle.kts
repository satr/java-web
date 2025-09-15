plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.openapi.generator") version "7.4.0"
}

group = "io.github.satr"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(24)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web:3.5.5")
	implementation("com.google.code.findbugs:jsr305:3.0.2")
	implementation("org.springframework.boot:spring-boot-starter:3.5.5")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf:3.5.5")
	implementation("org.springframework.boot:spring-boot-starter-actuator:3.5.5")
	implementation("javax.annotation:javax.annotation-api:1.3.2")
	implementation("org.openapitools:jackson-databind-nullable:0.2.6")
	implementation("org.springframework.boot:spring-boot-starter-security:3.5.5")
	implementation("org.springframework.boot:spring-boot-starter-oauth2-client:3.5.5")
	compileOnly("org.projectlombok:lombok:1.18.38")
	annotationProcessor("org.projectlombok:lombok:1.18.38")
	testCompileOnly("org.projectlombok:lombok:1.18.38")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

openApiGenerate {
	generatorName.set("java")
	inputSpec.set("${rootDir}/api/openapi.yaml")
	outputDir.set("${rootDir}/springapp/openapi-client")
	apiPackage.set("io.github.satr.springapp.api")
	modelPackage.set("io.github.satr.springapp.model")
	invokerPackage.set("io.github.satr.springapp.invoker")
	configOptions.set(mapOf(
		"library" to "resttemplate",
		"dateLibrary" to "java8"
	))
}

sourceSets {
	main {
		java {
			srcDir("openapi-client/src/main/java")
		}
	}
}

tasks.named("compileJava") {
	dependsOn("openApiGenerate")
}
