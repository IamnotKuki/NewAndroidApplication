plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
}

android {
    namespace = "ru.example.mynewapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.example.mynewapplication"
        minSdk = 24
        targetSdk = 35
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
}

dependencies {
    dependencies {
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.material)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.viewpager2)

        implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.10")
        implementation("androidx.core:core-ktx:1.13.0")
        implementation("androidx.appcompat:appcompat:1.7.0")
        implementation("com.google.android.material:material:1.12.0")

        implementation("androidx.fragment:fragment-ktx:1.6.1")

        implementation("androidx.room:room-runtime:2.7.2")
        kapt("androidx.room:room-compiler:2.7.2")
        implementation("androidx.room:room-ktx:2.7.2")

        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.9.1")
        //implementation("android.arch.persistence.room:runtime:1.1.1")
        //kapt("android.arch.persistence.room:compiler:1.1.1")

        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
    }
}
