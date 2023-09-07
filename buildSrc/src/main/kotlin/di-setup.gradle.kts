import gradle.kotlin.dsl.accessors._1aac24b857164f2e0bb2ae9832f4e245.android

plugins {
    id("com.android.library")
    id("com.google.devtools.ksp")
}

android{
    namespace = ProjectConfig.namespace
}

internal val Project.libs: VersionCatalog
    get() = project.extensions.getByType<VersionCatalogsExtension>().named("libs")

dependencies {
    implementation(libs.findLibrary("dagger").get())
    ksp(libs.findLibrary("daggerCompiler").get())
}
