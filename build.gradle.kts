import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.0"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.20"
    kotlin("plugin.spring") version "1.9.20"
    kotlin("plugin.jpa") version "1.9.20"
    id("org.flywaydb.flyway") version "7.12.0"
}

group = "me./chnu"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

extra["springModulithVersion"] = "1.1.0"

dependencies {
    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // spring-boot
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // validation
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // db
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    compileOnly("com.mysql:mysql-connector-j")

    // flyway
    implementation("org.flywaydb:flyway-core")
    implementation("org.flywaydb:flyway-mysql")

    // docker-compose
    implementation("org.springframework.boot:spring-boot-docker-compose")

    // kotlin-logging
    implementation("io.github.microutils:kotlin-logging:1.12.5")

//    // coroutine
//    implementation("org.springframework.boot:spring-boot-starter-webflux")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
//    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
//    testImplementation("io.projectreactor:reactor-test")
//
//    // modulith
//    implementation("org.springframework.modulith:spring-modulith-starter-core")
//    testImplementation("org.springframework.modulith:spring-modulith-starter-test")
//
//    // r2dbc
//    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.modulith:spring-modulith-bom:${property("springModulithVersion")}")
    }
    //treep
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks {
    withType<Test> {
        useJUnitPlatform()
    }

    flyway {
        url = "jdbc:mysql://mysql:3306/assignment"
        user = "root"
        password = "fastcampus"
    }
}
