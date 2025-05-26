plugins {
    alias(libs.plugins.custom.android.library)
}

android {
    namespace = "%PACKAGE%.presentation"
}

dependencies {
    api(projects.% MODULE_REFERENCE %.domain)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
}
