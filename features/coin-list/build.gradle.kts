plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.compose.compiller)
}

android {
    namespace = "com.kbcoding.cryptocurrency.fetures.coinlist"

    buildFeatures {
        compose = true
    }
}

dependencies {


    // Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(projects.data)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}