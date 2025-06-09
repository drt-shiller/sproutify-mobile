plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.compose)
    alias(libs.plugins.sproutify.android.library.jacoco)
}

android {
    namespace = "com.sproutify.ui"
}

dependencies {
//    api(libs.androidx.metrics)
    api(projects.core.analytics)
    api(projects.core.designsystem)
    api(projects.core.model)

//    implementation(libs.coil.kt)
//    implementation(libs.coil.kt.compose)
//
//    androidTestImplementation(libs.bundles.androidx.compose.ui.test)
//    androidTestImplementation(projects.core.testing)
}