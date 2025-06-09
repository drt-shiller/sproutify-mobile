plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.jacoco)
    alias(libs.plugins.sproutify.hilt)
}

android {
    namespace = "com.sproutify.database"
}

dependencies {
    api(projects.core.model)
}