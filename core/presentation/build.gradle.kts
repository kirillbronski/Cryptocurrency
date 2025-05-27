plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.compose.compiller)
    alias(libs.plugins.jetbrains.kotlin.serailization)
}

android {
    namespace = "com.kbcoding.cryptocurrency.core.presentation"

    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.kotlinx.serialization.core)

    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.activity.compose)
    api(libs.androidx.compose.ui)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material)
    implementation(libs.androidx.material3.android)

    implementation(libs.androidx.navigation.compose)

    implementation(projects.core.common)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}