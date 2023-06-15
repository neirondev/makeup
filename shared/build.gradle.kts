plugins {
    kotlin("plugin.serialization")
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")

}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    val coroutinesVersion = "1.6.4"
    val ktorVersion = "2.2.4"
    val sqlDelightVersion = "1.5.5"
    val dateTimeVersion = "0.4.0"
    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:$dateTimeVersion")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

                //implementation("com.soywiz.korlibs.korio:korio:2.4.10")
                //KorIO is a library for Charsets, Encodings, Checksums, Compression, I/O, Streams, Virtual File System, Networking, Http, WebSockets, Serialization…

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-serialization:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
                implementation("io.ktor:ktor-client-logging:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:1.5.3")

                implementation("io.ktor:ktor-client-ios:$ktorVersion")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt") {
                    version {
                        strictly("1.6.0-native-mt")
                    }
                }
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:1.5.3")

                implementation("io.ktor:ktor-client-android:$ktorVersion")
            }
        }
        /*val iosMain by creating {
            //dependsOn(commonMain)

            dependencies {
                implementation("com.squareup.sqldelight:native-driver:1.5.3")

                implementation("io.ktor:ktor-client-ios:2.0.0-beta-1")

                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt") {
                    version {
                        strictly("1.6.0-native-mt")
                    }
                }
            }

            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }*/

    }
}

android {
    namespace = "ge.neirondev.makeup"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}