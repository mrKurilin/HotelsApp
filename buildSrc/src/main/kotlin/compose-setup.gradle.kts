plugins {
    id("com.android.library")
}

internal val Project.libs: VersionCatalog
    get() = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

android {
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.findVersion("compose").get().toString()
    }
}

dependencies {
    implementation(libs.findBundle("compose").get())
}