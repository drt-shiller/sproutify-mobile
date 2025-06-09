plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.jacoco)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.sproutify.domain"
}

dependencies {
    api(projects.core.data)
    api(projects.core.model)

    implementation(libs.javax.inject)
}