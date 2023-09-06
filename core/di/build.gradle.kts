@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    `android-setup`
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
}

android {
    namespace = ProjectConfig.namespace("di")
}

dependencies {
    implementation("com.google.dagger:dagger:2.48")
    ksp("com.google.dagger:dagger-compiler:2.48")
}