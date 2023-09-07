plugins {
    `android-setup`
    `di-setup`
}

android {
    namespace = ProjectConfig.namespace("hotelFeature")
}

dependencies{
    implementation(project(":core:ui"))

    implementation(libs.flexbox)
}