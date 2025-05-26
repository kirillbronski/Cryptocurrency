plugins {
    alias(libs.plugins.conventions.androidLibrary)
}

android {
    namespace = "%PACKAGE%"
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
}