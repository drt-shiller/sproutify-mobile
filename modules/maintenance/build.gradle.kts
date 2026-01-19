plugins {
    alias(libs.plugins.sproutify.android.feature)
    alias(libs.plugins.sproutify.android.library.compose)
    alias(libs.plugins.sproutify.android.library.jacoco)
}

android {
    namespace = "com.sproutify.maintenance"
}

dependencies {
    implementation(projects.core.module)
}