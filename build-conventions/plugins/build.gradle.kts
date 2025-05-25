import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

val catalog = the<LibrariesForLibs>()

dependencies {
    implementation(files(catalog.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.android)
}

gradlePlugin {
    plugins {
        register("sharedAndroidLibraryConfig") {
            id = "com.uandcode.conventions.android.library"
            implementationClass = "SharedAndroidLibraryConfig"
        }
    }
}
