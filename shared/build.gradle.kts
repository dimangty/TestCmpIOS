import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.compose")
    alias(libs.plugins.compose.mp)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.navigation.compose)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            //put your multiplatform dependencies here

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(libs.koin.core)
            implementation(libs.ktor.client.core)
            implementation(libs.androidx.lifecycle.viewmodel)
            implementation(libs.kotlinx.serialization)
        }
    }
}

android {
    namespace = "com.example.testcmp"
    compileSdk = libs.versions.compileAndroidSdk.get().toInt()
    defaultConfig {
        minSdk = libs.versions.minAndroidSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
