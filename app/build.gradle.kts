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
        versionName = "1.0"

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
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation("androidx.activity:activity-compose:1.6.0")
    implementation("androidx.compose.ui:ui:1.3.0-beta03")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.0-beta03")
    implementation("androidx.compose.material3:material3:1.0.0-beta03")
    debugImplementation("androidx.customview:customview:1.2.0-alpha02")
    debugImplementation("androidx.customview:customview-poolingcontainer:1.0.0")
}