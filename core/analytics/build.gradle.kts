plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.compose)
    alias(libs.plugins.sproutify.hilt)
}

android {
    namespace = "com.sproutify.analytics"
}

dependencies {
    implementation(libs.androidx.compose.runtime)
    // Migrate to Prod version
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
}