plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "shov.allapis.ui"
    compileSdk = 33

    defaultConfig {
        minSdk = 26

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

        debug {
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
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }

    detekt {
        toolVersion = "1.22.0-RC1"
        config = files("config/detekt/detekt.yml")
        buildUponDefaultConfig = true
    }
}

dependencies {
    //ui
    implementation(libs.compose.foundation)
    implementation(libs.compose.material3)
    implementation(libs.compose.icons)
    implementation(libs.compose.runtime)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    implementation(libs.accompanist.systemuicontroller)
    debugImplementation(libs.compose.tooling)

    //di
    implementation(libs.hilt.android)
    implementation(libs.hilt.viewmodel)
    kapt(libs.hilt.compiler)

    //datastore
    implementation(projects.core.datastore)
    implementation(libs.datastore)

    //tests
    detektPlugins(libs.twitter.detekt)
}
