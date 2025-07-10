plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.retail.sosaxle"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.retail.sosaxle"
        minSdk = 31
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
    // Include resource directories for tests
    sourceSets {


    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    androidTestImplementation(libs.junit)
    // Appium Java Client
    androidTestImplementation(libs.appium.javaClient)
    androidTestImplementation(libs.testng)

    // TestNG for test execution (CHOOSE ONE testing framework)
    androidTestImplementation(libs.testng)
    // SLF4J for logging
    androidTestImplementation(libs.slf4j.simple)

    // Optional: AndroidX UIAutomator
    // If used in an Android project's instrumented tests
    androidTestImplementation("org.apache.commons:commons-lang3:3.12.0")
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.testng.testng)
    androidTestImplementation("commons-io:commons-io:2.11.0")

    androidTestImplementation (libs.jackson.databind)
    androidTestImplementation (libs.jackson.core)
    androidTestImplementation (libs.jackson.annotations)

}