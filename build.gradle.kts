import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

allprojects {
    group = Project.GROUP
    version = Project.VERSION

    repositories {
        mavenCentral()
    }
}

plugins {
    id(Plugins.SPRING_BOOT) version Version.SPRING_BOOT
    id(Plugins.SPRING_DEPENDENCY_MANAGEMENT) version Version.SPRING_DEPENDENCY_MANAGEMENT
    id(Plugins.KOTLIN_JVM) version Version.KOTLIN
    id(Plugins.KOTLIN_PLUGIN_JPA) version Version.KOTLIN
    id(Plugins.KOTLIN_PLUGIN_SPRING) version Version.KOTLIN
}

subprojects {
    apply(plugin = Plugins.IDEA)
    apply(plugin = Plugins.KOTLIN)
    apply(plugin = Plugins.KOTLIN_SPRING)
    apply(plugin = Plugins.KOTLIN_JPA)
    apply(plugin = Plugins.KOTLIN_KAPT)
    apply(plugin = Plugins.KOTLIN_NOARG)
    apply(plugin = Plugins.KOTLIN_ALLOPEN)
    apply(plugin = Plugins.SPRING_BOOT)
    apply(plugin = Plugins.SPRING_DEPENDENCY_MANAGEMENT)

    dependencies {
        implementation(Dependencies.KOTLIN_STDLIB)
        implementation(Dependencies.KOTLIN_REFLECT)

        annotationProcessor(Dependencies.SPRING_BOOT_CONFIGURATION_PROCESSOR)

        testImplementation(Dependencies.KOTEST_RUNNER_JUNIT5)
        testImplementation(Dependencies.KOTEST_ASSERTIONS_CORE)
        testImplementation(Dependencies.KOTEST_EXTENSIONS_SPRING)
        testImplementation(Dependencies.SPRING_BOOT_STARTER_TEST)
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(Version.JAVA))
        }
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = Version.JAVA
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}
