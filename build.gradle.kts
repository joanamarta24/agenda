import sun.jvmstat.monitor.MonitoredVmUtil.mainClass

plugins {
    id("java")
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // ou 17 se preferir
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // JUnit
    testImplementation(platform("org.junit:junit-bom:5.10.2"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // SQLite
    implementation("org.xerial:sqlite-jdbc:3.46.0.0")

    // Log (opcional, mas útil)
    implementation("org.slf4j:slf4j-simple:2.0.13")
}


tasks.test {
    useJUnitPlatform()
}