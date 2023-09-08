plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("bookingFeature")
}

dependencies{
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":core:navigation"))
}