plugins {
    application
    id("org.jetbrains.kotlin.jvm")
}

interface CustomKotlinScriptExtension {
    val scriptName: Property<String>
    val mainClass: Property<String>
}

val extension = extensions.create<CustomKotlinScriptExtension>("kotlinScript")

tasks.register<Jar>("fatJar") {
    group = "build"
    archiveBaseName = extension.scriptName
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
    manifest {
        attributes["Main-Class"] = extension.mainClass
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
    }
}