plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    compileSdk = 34
    namespace = ProjectConfig.namespace
    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildToolsVersion = "33.0.2"
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":hotelFeature"))
    implementation(project(":roomsFeature"))
    implementation(project(":bookingFeature"))

    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintLayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.bundles.androidTests)
    implementation(libs.navigationFragmentKtx)
    implementation(libs.dagger)
    implementation(libs.daggerAndroid)
    ksp(libs.daggerCompiler)

    implementation(libs.kotlinSerializationCore)
    implementation(libs.kotlinSerializationJson)
    implementation(libs.bundles.network)
}