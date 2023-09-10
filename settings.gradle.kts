pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "HotelsApp"
include(":app")
include(":hotelFeature")
include(":roomsFeature")
include(":bookingFeature")
include(":core:navigation")
include(":core:di")
include(":core:ui")
