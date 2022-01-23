plugins {
    id("com.android.application")
    id("kotlin-android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs")
    id("kotlin-android-extensions")
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.home.starter"
        minSdk = 24
        targetSdk = 30
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("**/attach_hotspot_windows.dll")
        exclude("META-INF/licenses/**")
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Support
    implementation(Dependencies.KOTLIN_STDLIB)
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAINT_LAYOUT)

    // Architecture Components
    implementation(Dependencies.LIFECYCLE_EXTENSIONS)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL_KTX)
    implementation(Dependencies.LIFECYCLE_CORE)
    implementation(Dependencies.LIFECYCLE_LIVEDATA)
    implementation(Dependencies.LIFECYCLE_RUNTIME)
    implementation(Dependencies.LIFECYCLE_VIEWMODEL_SAVESTATE)
    implementation(Dependencies.LIFECYCLE_PROCESSOR)
    implementation(Dependencies.LIFECYCLE_CORE_TESTING)

    // Navigation Component
    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    androidTestImplementation("androidx.navigation:navigation-testing:2.3.5")

    // Dagger Hilt
    // Hilt dependencies
    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    // Hilt testing dependencies
    androidTestImplementation(Dependencies.HILT_TEST)
    kaptAndroidTest(Dependencies.HILT_COMPILER)

    // Room
    implementation("androidx.room:room-runtime:${Versions.ROOM_VERSION}")
    annotationProcessor("androidx.room:room-compiler:${Versions.ROOM_VERSION}")
    kapt("androidx.room:room-compiler:${Versions.ROOM_VERSION}")
    implementation("androidx.room:room-ktx:${Versions.ROOM_VERSION}")
    implementation("com.google.code.gson:gson:2.8.7")

    // Work manger
    implementation("androidx.work:work-runtime-ktx:2.5.0")
    implementation("com.google.guava:listenablefuture:9999.0-empty-to-avoid-conflict-with-guava")

    //test
    testImplementation(Dependencies.MOCKITO_CORE)
    testImplementation("org.mockito:mockito-inline:2.13.0")
    implementation(Dependencies.RULES)
    implementation(Dependencies.RUNNER)
    debugImplementation("androidx.test:core:1.2.0")
    androidTestImplementation(Dependencies.JUNIT)
    androidTestImplementation(Dependencies.ESPRESSO_CORE)
    debugImplementation(Dependencies.FRAGMENT_TEST)

    // Coroutines
    implementation(Dependencies.COROUTINES_TEST)
    implementation(Dependencies.COROUTINES_CORE)

    testImplementation("org.mockito:mockito-inline:2.13.0")

    //Coil
    implementation(Dependencies.COIL)

    //datastore
    implementation(Dependencies.DATA_STORE_CORE)
    implementation(Dependencies.DATA_STORE)

    //FlexBox
    implementation(Dependencies.FLEX_BOX)

    //Biometric
    implementation("androidx.biometric:biometric:1.2.0-alpha03")

    //SECURITY_CRYPTO
    implementation(Dependencies.SECURITY_CRYPTO)

    // Retrofit
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)

    //FB SHIMMER
    implementation(Dependencies.FB_SHIMMER)

    //JODA Time
    implementation("joda-time:joda-time:2.10.13")

    //Exo Player
    implementation ("com.google.android.exoplayer:exoplayer:2.16.1")

}