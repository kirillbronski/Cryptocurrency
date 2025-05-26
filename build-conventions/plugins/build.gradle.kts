import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    `kotlin-dsl`
}

val catalog = the<LibrariesForLibs>()

dependencies {
    implementation(files(catalog.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.android)
    implementation(libs.plugin.kotlin.jvm)
}

gradlePlugin {
    plugins {
        register("sharedAndroidLibraryConfig") {
            id = "com.kbcoding.cryptocurrency.android.library"
            implementationClass = "SharedAndroidLibraryConfig"
        }
        register("sharedKotlinLibraryConfig") {
            id = "com.kbcoding.cryptocurrency.kotlin.library"
            implementationClass = "SharedKotlinLibraryConfig"
        }
    }
}
