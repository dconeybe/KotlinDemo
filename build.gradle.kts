plugins {
    kotlin("jvm") version "2.0.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}

tasks.register("printSystemProperties") {
    doLast {
        System.getProperties().entries.sortedBy { "${it.key}".lowercase() }.forEach {
            println("${it.key}: ${it.value}")
        }
    }
}

tasks.register("printSystemInformation") {
    doLast {
        println("embeddedKotlinVersion: $embeddedKotlinVersion")
    }
}
