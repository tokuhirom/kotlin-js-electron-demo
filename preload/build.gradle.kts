plugins {
    kotlin("multiplatform") version "2.0.0"
}

kotlin {
    js {
        moduleName = "preload"
        nodejs {
        }
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.754"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-electron")
                implementation(npm("electron", "30.0.8"))
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

