plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}
android {
    namespace = "net.classcard.autocard"
    compileSdk = 35
    defaultConfig {
        applicationId = "net.classcard.autocard"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0"
    }
}
