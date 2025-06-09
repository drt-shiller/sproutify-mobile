package com.sproutify.sproutify

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.ProductFlavor

@Suppress("EnumEntryName")
enum class FlavorDimension {
    contentType
}

// The content for the app can either come from local static data which is useful for demo
// purposes, or from a production backend server which supplies up-to-date, real content.
// These two product flavors reflect this behaviour.
@Suppress("EnumEntryName")
enum class SprtFlavor(val dimension: FlavorDimension, val applicationIdSuffix: String? = null) {
    qa(FlavorDimension.contentType, applicationIdSuffix = ".qa"),
    prod(FlavorDimension.contentType),
}

fun configureFlavors(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    flavorConfigurationBlock: ProductFlavor.(flavor: SprtFlavor) -> Unit = {},
) {
    commonExtension.apply {
        FlavorDimension.values().forEach { flavorDimension ->
            flavorDimensions += flavorDimension.name
        }

        productFlavors {
            SprtFlavor.values().forEach { sprtFlavor ->
                register(sprtFlavor.name) {
                    dimension = sprtFlavor.dimension.name
                    flavorConfigurationBlock(this, sprtFlavor)
                    if (this@apply is ApplicationExtension && this is ApplicationProductFlavor) {
                        if (sprtFlavor.applicationIdSuffix != null) {
                            applicationIdSuffix = sprtFlavor.applicationIdSuffix
                        }
                    }
                }
            }
        }
    }
}