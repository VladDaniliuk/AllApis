plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    namespace = "shov.allapis"
    compileSdk = 33

    defaultConfig {
        applicationId = "shov.allapis"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isDebuggable = false
        }
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.1"
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    buildToolsVersion = "33.0.0"
}

dependencies {
    implementation(libs.core)
    implementation(libs.lifecycle)
    implementation(libs.activity)
    implementation(libs.compose.animation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.icons)
    implementation(libs.compose.material3.window)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    implementation(libs.accompanist.systemuicontroller)
    debugImplementation(libs.compose.tooling)
}
