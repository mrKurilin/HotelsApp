plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("hotelRoomFeature")
}

dependencies{
    implementation(project(":core:ui"))
}