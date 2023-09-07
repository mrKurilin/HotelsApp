plugins {
    `android-setup`
}

android {
    namespace = ProjectConfig.namespace("roomsFeature")
}

dependencies{
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
}