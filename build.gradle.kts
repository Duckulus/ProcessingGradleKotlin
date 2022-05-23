import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.johnrengelman.shadow") version "7.1.2"
    application
    kotlin("jvm") version "1.6.20"
}

group = "org.example"
version = "0.1"

dependencies {
    implementation(fileTree("libs") { include("*.jar") })
    implementation(kotlin("stdlib-jdk8"))
}

application {
    mainClass.set("org.example.MainKt")
}
repositories {
    mavenCentral()
}

tasks {
    withType<JavaCompile> {
        options.release.set(17)
        options.encoding = "UTF-8"
    }

    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }
}