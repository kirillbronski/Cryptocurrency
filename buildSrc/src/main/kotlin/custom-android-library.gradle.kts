plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = Const.TARGET_SDK

    defaultConfig {
        minSdk = Const.MIN_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        buildConfig = true
    }
}