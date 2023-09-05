plugins {
	java
	id("org.springframework.boot") version "2.7.14"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "co.edu.unisabana"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	// https://mvnrepository.com/artifact/org.springframework.data/spring-data-jpa
	implementation("org.springframework.data:spring-data-jpa:2.7.15")
	// https://mvnrepository.com/artifact/mysql/mysql-connector-java
	implementation("mysql:mysql-connector-java:8.0.30")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
