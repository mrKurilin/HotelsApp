plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("bookingFeature")
}

dependencies{
    implementation(project(":core:ui"))
}