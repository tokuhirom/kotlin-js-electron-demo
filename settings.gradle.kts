plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "kotlin-js-electron-demo"

include(":main")
include(":preload")
include(":renderer")
