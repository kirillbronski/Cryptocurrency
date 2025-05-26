plugins {
    alias(libs.plugins.custom.kotlin.script)
}

kotlinScript {
    scriptName = "createModule"
    mainClass = "com.kbcoding.android.templates.script.MainKt"
}

tasks.register<Copy>("bundleScript") {
    dependsOn("fatJar")
    group = "build"
    description = "Builds the script and copies it to the build directory."
    from(tasks.named("fatJar").get().outputs.files)
    into(rootDir)
}

dependencies {

}

