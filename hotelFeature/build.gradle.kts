plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("hotelFeature")
}

dependencies{
    implementation(project(":core:ui"))
}