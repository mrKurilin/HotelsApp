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
include(":hotelRoomFeature")
include(":bookingFeature")
include(":core:navigation")
include(":core:di")
