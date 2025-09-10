plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
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
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-maven-plugin:3.5.5")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
	implementation("org.springdoc:springdoc-openapi-starter-common:2.5.0")
	implementation("org.springdoc:springdoc-openapi-ui:1.7.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	compileOnly("org.projectlombok:lombok:1.18.38")
	annotationProcessor("org.projectlombok:lombok:1.18.38")
	testCompileOnly("org.projectlombok:lombok:1.18.38")
	testAnnotationProcessor("org.projectlombok:lombok:1.18.38")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

// Task to export OpenAPI spec
val exportOpenApiSpec by tasks.registering(JavaExec::class) {
	group = "documentation"
	description = "Exports OpenAPI spec to openapi.yaml"
	classpath = sourceSets["main"].runtimeClasspath
	mainClass.set("io.github.satr.api.ApiApplication") // Update with your main class
	args = listOf("--springdoc.api-docs.path=/v3/api-docs.yaml", "--springdoc.api-docs.enabled=true")
	environment["SPRING_PROFILES_ACTIVE"] = "openapi"
}

tasks.register<Exec>("fetchOpenApiYaml") {
	group = "documentation"
	description = "Fetches OpenAPI YAML from running server and saves to build/openapi.yaml"
	commandLine("curl", "-o", "build/openapi.yaml", "http://localhost:8081/v3/api-docs.yaml")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
