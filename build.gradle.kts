import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.4.31"
val autoService = "1.0-rc6"

plugins {
    `java-gradle-plugin` apply true
    kotlin("jvm") version "1.4.31"
    kotlin("kapt") version "1.4.31"
    id("com.gradle.plugin-publish") version "0.14.0"
    `maven-publish`
}

group = "dev.gitlive"
version = "1.0.0"

repositories {
    mavenCentral()
}

description = "Gitlive gradle plugin, for serving the javascript types plugin"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin-api:${kotlin_version}")

    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:${kotlin_version}")

    compileOnly("com.google.auto.service:auto-service-annotations:${autoService}")
    kapt("com.google.auto.service:auto-service:${autoService}")
}

gradlePlugin {
    plugins {
        create("gitlivePlugin") {
            id = "dev.gitlive"
            displayName = "Gitlive Plugin"
            description = "Gitlive Kotlin plugin"
            implementationClass = "dev.gitlive.GitliveGradlePlugin"
        }
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

pluginBundle {
    website = "https://github.com/rnett/krosstalk"
    vcsUrl = "https://github.com/rnett/krosstalk.git"
    tags = listOf("kotlin", "js", "server", "api")
}