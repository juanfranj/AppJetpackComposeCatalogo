import org.jetbrains.kotlin.kapt3.base.Kapt.kapt


plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
    //Incluir Firebase
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
}

android {
    namespace = "com.cursojetpackcompose.jetpackcomposecatalogomio"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.cursojetpackcompose.jetpackcomposecatalogomio"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

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
        debug {
            applicationIdSuffix = ".debug"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val nav_version = "2.7.7"


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0-alpha13")
    // To use constraintlayout in compose
    implementation("androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha13")
    // To use images on line con Coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    //Hace falta dar permisos en AndroidManifest.xml
    //<uses-permission android:name="android.permission.INTERNET" />
    //Incluir libreria de iconos extendida
    implementation("androidx.compose.material:material-icons-extended:1.2.1")
    //To use navigation
    implementation("androidx.navigation:navigation-compose:$nav_version")
    //To use viewmodel and livedata
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.5.1")

    //To use retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    //implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    //To use DaggerHilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //To use Flow
    //implementation("androix.lifecycle:lifecycle-viewmodel-ktx:2.6.2") implementamos el viewmodel pero usamos el del compose
    //implementation("androix.activity:activity-ktx:1.7.2")
    //To implement AdMob
    implementation ("com.google.android.gms:play-services-ads:23.1.0")

    //To use Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    //To use Firebase Analytics
    implementation("com.google.firebase:firebase-analytics-ktx")
    //To use Firebase Crashlytics
    implementation("com.google.firebase:firebase-crashlytics-ktx")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}


