plugins {
    alias(libs.plugins.conventions.kotlinLibrary)
}

dependencies {
    // Retrofit
    implementation(libs.retrofit2)
    implementation(libs.retrofit2.converter)
    implementation(libs.okhttp.interceptor)
}