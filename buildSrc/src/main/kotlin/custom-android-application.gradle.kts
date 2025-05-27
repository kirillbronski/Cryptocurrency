plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    compileSdk = Const.TARGET_SDK

    defaultConfig {
        minSdk = Const.MIN_SDK
        targetSdk = Const.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlin {
        jvmToolchain(Const.JDK_VER)
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

// Sample v1
//val material3Dependency = library("androidx-material3")

// Sample v2
//private val libs = the<LibrariesForLibs>()

dependencies {
    //implementation(library("androidx-material3")) //v1
    //implementation(libs.androidx.material3) // v2
}