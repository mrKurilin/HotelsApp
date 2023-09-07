plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("hotelFeature")
}

dependencies{
    implementation(project(":core:ui"))
    implementation(project(":core:navigation"))

    implementation(libs.flexbox)
}