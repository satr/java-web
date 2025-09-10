plugins {
    id("java")
    id("org.openapi.generator") version "7.4.0"
}

group = "io.github.satr"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

openApiGenerate {
    generatorName.set("java")
    inputSpec.set("${rootDir}/api/build/openapi.yaml")
    outputDir.set("${rootDir}/springapp/build/generated/openapi-client")
    apiPackage.set("io.github.satr.springapp.api")
    modelPackage.set("io.github.satr.springapp.model")
    invokerPackage.set("io.github.satr.springapp.invoker")
    configOptions.set(
        mapOf(
            "library" to "resttemplate", // or "webclient" for reactive
            "dateLibrary" to "java8"
        )
    )
}
sourceSets["main"].java.srcDir("$rootDir/springapp/generated/openapi-client/src/main/java")