import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

dependencies {
    implementation(project(":sidematch-common"))
    implementation(project(":sidematch-domain"))

    implementation("org.springframework.boot:spring-boot:${Version.SPRING_BOOT}")
}
