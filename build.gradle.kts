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
            url = uri("https://maven.pkg.github.com/TheMather1/TemporalCollections")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register<MavenPublication>("jar") {
            from(components["java"])
        }
    }
}
