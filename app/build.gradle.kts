plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = ProjectConfig.compileSdk
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
            buildConfigField("boolean", "isDebug", "false")
        }
        debug {
            buildConfigField("boolean", "isDebug", "true")
        }
    }

    compileOptions {
        sourceCompatibility = ProjectConfig.javaVersion
        targetCompatibility = ProjectConfig.javaVersion
    }

    kotlinOptions {
        jvmTarget = ProjectConfig.jvmTarget
    }
}

dependencies {
    implementation(project(":core:navigation"))
    implementation(project(":core:ui"))
    implementation(project(":hotelFeature"))

    implementation(libs.coreKtx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintLayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidJunit)
    androidTestImplementation(libs.espressoCore)
    implementation(libs.navigationFragmentKtx)
}