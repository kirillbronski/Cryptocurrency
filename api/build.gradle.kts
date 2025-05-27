plugins {
    alias(libs.plugins.custom.kotlin.library)
}

dependencies {
    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter)
    implementation(libs.okhttp.interceptor)
    testImplementation(libs.junit)
}