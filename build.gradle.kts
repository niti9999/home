plugins {
    java
    id("org.springframework.boot") version "3.5.0"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.blr"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(24)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("io.cucumber:cucumber-spring:7.23.0")

    testImplementation("io.cucumber:cucumber-junit:7.23.0")

    implementation("io.cucumber:cucumber-java:7.23.0")

    //mongo atlas
    implementation("org.mongodb:mongodb-driver-sync:5.4.0")

    //playwright
    implementation("com.microsoft.playwright:playwright:1.44.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
