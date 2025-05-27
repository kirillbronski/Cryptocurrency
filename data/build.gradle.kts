plugins {
    alias(libs.plugins.custom.android.library)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.kbcoding.cryptocurrency.data"
}

dependencies {

    // Hilt
    implementation(libs.hilt)
    ksp(libs.hilt.compiler)

    implementation(projects.api)
    implementation(projects.core.common)

    implementation(libs.javax.inject)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}