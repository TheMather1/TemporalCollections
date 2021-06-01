plugins {
    kotlin("jvm") version "1.5.10"
    `java-library`
    `maven-publish`
}

group = "no.mather.temporal"
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
            url = uri("https://maven.pkg.github.com/TheMather1/temporal-collections")
            credentials {
                username = System.getenv("GITHUB_ACTOR")
                password = System.getenv("GITHUB_TOKEN")
            }
        }
    }
    publications {
        register("gpr", MavenPublication::class) {
            artifactId = "temporal-collections"
            from(components["java"])
            pom {
                name.set("Temporal Collections")
                description.set("Collections for mapping data by time.")
                url.set("https://github.com/TheMather1/temporal-collections")
                inceptionYear.set("2021")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://www.opensource.org/licenses/mit-license.php")
                    }
                }
                developers {
                    developer {
                        name.set("Mathias Sand Jahren")
                        email.set("the.mather1@gmail.com")
                        url.set("https://github.com/TheMather1")
                        timezone.set("CET")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/TheMather1/temporal-collections.git")
                    developerConnection.set("scm:git:ssh://github.com/TheMather1/temporal-collections.git")
                    url.set("https://github.com/TheMather1/temporal-collections/tree/main")
                }
            }
        }
    }
}
