plugins {
    kotlin("jvm") version "1.5.10"
    `java-library`
    `maven-publish`
}

group = "no.github.mather"
version = System.getenv("RELEASE_VERSION")

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
}

java {
    withSourcesJar()
    withJavadocJar()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/TheMather1/${rootProject.name}")
            credentials {
                username = findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
                password = findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("jar") {
            from(components["java"])
        }
    }
}
