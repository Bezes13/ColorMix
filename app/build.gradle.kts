plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.games.colormix"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.games.colormix"
        minSdk = 24
        targetSdk = 34
        versionCode = 15
        versionName = "1.5"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core AndroidX Libraries
    implementation("androidx.core:core-ktx:1.12.0") // Kotlin extensions for core Android APIs

// Lifecycle Libraries
    val lifecycleVersion = "2.7.0"
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion") // Kotlin extensions for Android Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion") // ViewModel support in Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion") // ViewModel support with Kotlin extensions
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion") // Compose integration with Android Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVersion") // ViewModel saved state support

// Navigation Libraries
    val navVersion = "2.7.7"
    implementation("androidx.navigation:navigation-compose:$navVersion") // Compose integration for Jetpack Navigation

// Dependency Injection (Hilt)
    implementation("com.google.dagger:hilt-android:2.48") // Hilt for dependency injection in Android
    kapt("com.google.dagger:hilt-android-compiler:2.48") // Hilt compiler for code generation
    implementation("androidx.hilt:hilt-work:1.2.0") // Hilt integration with WorkManager
    kapt("androidx.hilt:hilt-compiler:1.2.0") // Hilt compiler for AndroidX integration
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0") // Hilt navigation support with Compose

// WorkManager
    implementation("androidx.work:work-runtime-ktx:2.9.0") // Kotlin extensions for WorkManager

// Compose UI & Material
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.foundation:foundation:1.7.0-beta07")

    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

// Testing Libraries
    testImplementation("junit:junit:4.13.2") // JUnit 4 for unit testing
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // AndroidX JUnit extensions for Android tests
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Espresso for UI testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00")) // BOM for managing Compose versions in tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4") // UI testing with JUnit4 for Compose

// Additional Libraries
    implementation("androidx.graphics:graphics-shapes-android:1.0.0") // AndroidX graphics shapes library
    implementation("com.google.code.gson:gson:2.10") // GSON for JSON serialization/deserialization

}