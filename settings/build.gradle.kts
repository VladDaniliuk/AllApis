plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
}

android {
    namespace = "shov.allapis.settings"
    compileSdk = 33

    defaultConfig {
        minSdk = 26
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

    detekt {
        toolVersion = "1.22.0-RC1"
        config = files("config/detekt/detekt.yml")
        buildUponDefaultConfig = true
    }
}

dependencies {
    //ui
    implementation(libs.compose.foundation)
    implementation(libs.compose.icons)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    debugImplementation(libs.compose.tooling)

    //datastore
    implementation(projects.core.datastore)
    implementation(libs.datastore)

    //tests
    detektPlugins(libs.twitter.detekt)
}