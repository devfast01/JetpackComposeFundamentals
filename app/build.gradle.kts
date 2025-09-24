plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.2.20"  // Direct approach
}

android {
    namespace = "com.example.jetpackcomposefundamentals"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.jetpackcomposefundamentals"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Jetpack Compose Animation :->
    implementation(libs.androidx.animation)
    implementation(libs.androidx.animation.core)
    implementation(libs.androidx.foundation)
    // Coil Compose :->
    implementation(libs.coil)

    //TODO Navigation
    implementation("androidx.navigation:navigation-compose:2.9.4")
    // TODO Compose animation
    implementation("androidx.compose.animation:animation:1.7.4")
    // TODO Glassmorphic effect
    implementation("dev.chrisbanes.haze:haze-jetpack-compose:0.4.1")
    //TODO Json Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.9.0")
    // TODO ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout-compose-android:1.1.1")
    implementation("io.coil-kt:coil-compose:2.5.0")
    // collections
    implementation(libs.collections)
    // compose lifecycle
    implementation(libs.compose.lifecycle)
}