package com.sproutify.sproutify

/**
 * This is shared between :app and :benchmarks module to provide configurations type safety.
 */
enum class SprtBuildType(val applicationIdSuffix: String? = null) {
    DEBUG(".debug"),
    RELEASE,
}