plugins {
    alias(libs.plugins.sproutify.android.library)
    alias(libs.plugins.sproutify.android.library.jacoco)
    alias(libs.plugins.sproutify.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.sproutify.data"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(projects.core.analytics)

    api(projects.core.network)
    api(projects.core.common)
    api(projects.core.database)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
}