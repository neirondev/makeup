plugins {
    id("com.android.application")

    kotlin("android")
}

android {
    namespace = "ge.neirondev.makeup.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "ge.neirondev.makeup.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
val compose_version = "1.4.3"
dependencies {
    implementation(project(":shared"))
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation( "androidx.compose.material:material:1.4.3")

    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.activity:activity-compose:1.7.2")

    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.0-beta02")
    implementation ("androidx.compose.runtime:runtime-livedata:$compose_version")

    //implementation platform('androidx.compose:compose-bom:2023.05.01')
}