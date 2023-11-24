import org.springframework.boot.gradle.tasks.bundling.BootJar

val jar: Jar by tasks
val bootJar: BootJar by tasks

jar.enabled = true
bootJar.enabled = false

val exposedVersion = "0.44.1"
val postgresVersion = "42.2.5"
val h2Version = "2.1.214"

dependencies {
    implementation(project(":sidematch-common"))
    implementation(project(":sidematch-domain"))
    implementation(project(":sidematch-application"))

    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:$exposedVersion")
    runtimeOnly("org.postgresql:postgresql:$postgresVersion")
    testRuntimeOnly("com.h2database:h2:$h2Version")
}
