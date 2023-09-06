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
        kotlinCompilerExtensionVersion = Dependencies.Compose.compilerVersion
    }
}

dependencies {
    implementation(libs.findBundle("compose").get())
}