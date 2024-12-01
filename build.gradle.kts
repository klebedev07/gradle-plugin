plugins {
    `kotlin-dsl` // Enables writing Gradle scripts in Kotlin
    `java-gradle-plugin` // For developing Gradle plugins
    id("org.jetbrains.kotlin.jvm") version "1.8.0" // Kotlin JVM plugin
    id("org.jetbrains.kotlin.plugin.spring") version "1.8.0" // Kotlin Spring plugin
    id("org.jetbrains.kotlin.plugin.allopen") version "1.8.0" // Kotlin all-open plugin
}

group = "com.dev4team"
version = "1.0.0"

val kotlinVersion = "1.8.0"
val springBootVersion = "3.1.0"
val springDependencyManagementVersion = "1.1.0"
val springDocVersion = "2.1.0"
val jacksonVersion = "2.14.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(gradleApi())
    implementation(kotlin("stdlib"))
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    implementation("io.spring.gradle:dependency-management-plugin:$springDependencyManagementVersion")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
}

// Define the Gradle plugin
gradlePlugin {
    plugins {
        create("dev4TeamPlugin") {
            id = "com.dev4team.plugin"
            implementationClass = "com.dev4team.plugin.Dev4TeamPlugin"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "17"
    }
}
