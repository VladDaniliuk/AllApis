import com.android.build.api.dsl.ApkSigningConfig
import com.android.build.api.dsl.ApplicationProductFlavor
import io.gitlab.arturbosch.detekt.Detekt
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.detekt)
}

android {
    signingConfigs {
        createSigningConfig("github")
        createSigningConfig("google")
    }

    namespace = "shov.allapis"
    compileSdk = 33

    defaultConfig {
        applicationId = "shov.allapis"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"
        setProperty("archivesBaseName", "AllApis")

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    setFlavorDimensions(listOf("store"))

    productFlavors {
        createProductFlavor(signingConfigs, "github")
        createProductFlavor(signingConfigs, "google")
    }

    buildTypes {
        release {
            isDebuggable = false

            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        debug {
            isDebuggable = true

            isMinifyEnabled = false
            isShrinkResources = false
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

    buildToolsVersion = "33.0.0"

    detekt {
        toolVersion = "1.22.0-RC1"
        config = files("config/detekt/detekt.yml")
        buildUponDefaultConfig = true
    }

    tasks {
        withType<Detekt>().configureEach {
            reports {
                md.required.set(true)
            }
        }

        register("compareVersions") {
            val tagVersion = project.properties["tagVersion"] as String

            if (tagVersion.isEmpty()) {
                print(true)
            } else {
                val (tagMajor, tagMinor, tagPatch) = tagVersion.split(".")
                val (major, minor, patch) = android.defaultConfig.versionName!!.split(".")

                if (tagMajor < major) {
                    print(true)
                } else if ((tagMinor < minor) and (tagMajor == major)) {
                    print(true)
                } else if ((tagPatch < patch) and (tagMinor == minor) and (tagMajor == major)) {
                    print(true)
                } else {
                    print(false)
                }
            }
        }

        register("getVersionName") {
            doLast {
                print(android.defaultConfig.versionName)
            }
        }
    }
}

fun NamedDomainObjectContainer<ApplicationProductFlavor>.createProductFlavor(
    signingConfigs: NamedDomainObjectContainer<out ApkSigningConfig>,
    name: String
) {
    create(name) {
        dimension = "store"
        applicationIdSuffix = ".$name"
        signingConfig = signingConfigs.getByName(name)
    }
}

fun NamedDomainObjectContainer<out ApkSigningConfig>.createSigningConfig(name: String) {
    if (file("../$name-keystore.properties").exists().not()) {
        logger.warn("Release builds may not work: signing config doesn't found.")

        create(name)
    } else {
        val properties = Properties().also { properties ->
            properties.load(FileInputStream(file("../$name-keystore.properties")))
        }

        create(name) {
            keyAlias = properties["keyAlias"] as String
            keyPassword = properties["keyPassword"] as String
            storeFile = file(properties["storeFile"] as String)
            storePassword = properties["storePassword"] as String
        }
    }
}

dependencies {
    implementation(libs.core)
    implementation(libs.lifecycle)
    implementation(libs.activity)

    //ui
    implementation(libs.compose.animation)
    implementation(libs.compose.foundation)
    implementation(libs.compose.icons)
    implementation(libs.compose.material3.window)
    implementation(libs.compose.material3)
    implementation(libs.compose.runtime)
    implementation(libs.compose.preview)
    implementation(libs.compose.ui)
    implementation(projects.core.ui)
    implementation(libs.accompanist.navigation.animation)
    implementation(libs.accompanist.systemuicontroller)
    debugImplementation(libs.compose.tooling)

    //di
    implementation(libs.hilt.android)
    implementation(libs.hilt.viewmodel)
    kapt(libs.hilt.compiler)

    //datastore
    implementation(projects.core.datastore)
    implementation(libs.datastore)

    //features
    implementation(projects.feature.settings)

    //tests
    detektPlugins(libs.twitter.detekt)
}

kapt {
    correctErrorTypes = true
}
