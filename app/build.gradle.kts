plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiller)
    alias(libs.plugins.jetbrains.kotlin.serailization)
}

android {
    namespace = "com.bronski.cryptocurrency"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.bronski.cryptocurrency"
        minSdk = 26
        targetSdk = 34
        versionCode = 2
        versionName = "2.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        debug {
            isMinifyEnabled = false
        }
    }
    kotlin {
        jvmToolchain(17)
    }
    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//tasks.withType<JavaCompile>().configureEach {
//    options.compilerArgs.add("-Xlint:deprecation")
//}

dependencies {

    implementation(libs.kotlinx.serialization.core)

    // Compose dependencies
    implementation(libs.androidx.navigation.compose)

    // Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(libs.androidx.material3.android)

    // Retrofit
    compileOnly(libs.retrofit2)
    compileOnly(libs.retrofit2.converter)
    compileOnly(libs.okhttp.interceptor)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(projects.api)
    implementation(projects.data)
    implementation(projects.features.coinList)
    implementation(projects.features.coinDetail)
    implementation(projects.features.favorite)
}