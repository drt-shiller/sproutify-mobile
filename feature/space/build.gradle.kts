plugins {
    alias(libs.plugins.sproutify.android.feature)
    alias(libs.plugins.sproutify.android.library.compose)
    alias(libs.plugins.sproutify.android.library.jacoco)
}

android {
    namespace = "com.sproutify.space"
}

dependencies {
    implementation(projects.core.module)
    implementation(projects.modules.booking)
    implementation(projects.modules.maintenance)
}