plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.compose)
    alias(libs.plugins.sproutify.android.library.jacoco)
}

android {
    namespace = "com.sproutify.designsystem"
}

dependencies {
    lintPublish(projects.lint)

    api(libs.androidx.compose.foundation)
    api(libs.androidx.compose.foundation.layout)

    api(libs.androidx.compose.material3)
    api(libs.androidx.compose.runtime)
    api(libs.androidx.compose.ui.util)
}