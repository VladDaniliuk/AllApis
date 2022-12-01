plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
}

android {
    namespace = "shov.allapis.datastore"
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
    //data store
    implementation(libs.datastore)

    //tests
    detektPlugins(libs.twitter.detekt)
}
