import org.jetbrains.kotlin.gradle.utils.extendsFrom

plugins {
    kotlin("jvm") version "1.9.23"
    `java-library`
    `maven-publish`
}

subprojects {
    apply(plugin = "kotlin")
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")

    publishing {
        publications {
            create<MavenPublication>("library") {
                from(components["java"])
            }
        }
        repositories {
            mavenLocal()
            maven {
                url = uri("https://maven.pkg.github.com/lg-training/multimodule-gradle-kts")
                credentials {
                    username = System.getProperty("USERNAME")
                    password = System.getProperty("TOKEN")
                }
            }
        }
    }

}


allprojects {
    apply(from = "${rootProject.projectDir}/dependencies.gradle.kts")
    val extension = rootProject.extra

    group = "com.lg5"
    version = "1.0.0-alpha"

    java.sourceCompatibility = JavaVersion.VERSION_21

    configurations {
        compileOnly.extendsFrom(annotationProcessor)
        testCompileOnly.extendsFrom(annotationProcessor)
        testAnnotationProcessor.extendsFrom(annotationProcessor)
    }



    dependencies {

        testImplementation(extension.get("jupiter-api") as String)
        testImplementation(extension.get("jupiter-engine") as String)
        testRuntimeOnly(extension.get("jupiter-launcher") as String)

        annotationProcessor(extension.get("lombok") as String)
    }

    repositories {
        mavenLocal()
        mavenCentral()
    }


    tasks.test {
        useJUnitPlatform()
    }

    tasks.withType(JavaCompile::class) {
        options.encoding = "UTF-8"
    }


}



kotlin {
    jvmToolchain(21)
}
