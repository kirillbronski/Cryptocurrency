plugins {
    alias(libs.plugins.conventions.androidLibrary)
    alias(libs.plugins.compose.compiller)
}

android {
    namespace = "ru.scid.favorite"

    buildFeatures {
        compose = true
    }
}

dependencies {

    // Hilt
//    implementation(libs.hilt)
//    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)

    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(projects.data)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}