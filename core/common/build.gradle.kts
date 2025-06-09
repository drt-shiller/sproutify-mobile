plugins {
    alias(libs.plugins.sproutify.jvm.library)
    alias(libs.plugins.sproutify.hilt)
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}