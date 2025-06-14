pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "sproutify"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":lint")

check(JavaVersion.current().isCompatibleWith(JavaVersion.VERSION_17)) {
    """
    Now in Android requires JDK 17+ but it is currently using JDK ${JavaVersion.current()}.
    Java Home: [${System.getProperty("java.home")}]
    https://developer.android.com/build/jdks#jdk-config-in-studio
    """.trimIndent()
}
include(":core:ui")
include(":core:designsystem")
include(":core:domain")
include(":core:data")
include(":core:network")
include(":core:database")
include(":core:analytics")
include(":core:model")
include(":core:common")
include(":feature:auth")
include(":core:localization")

include(":feature:space")
include(":feature:feed")

