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
                implementation("org.jetbrains.kotlin-wrappers:kotlin-node")
            }
        }
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

// copy built files into target/preload/
tasks.register<Copy>("copyPreloadJsFiles") {
    group = "custom"
    description = "Copy JS files to target directory after compileSync"

    from(projectDir.resolve("build/compileSync/js/main/developmentExecutable/kotlin"))
    into(rootDir.resolve("target/preload/"))

    dependsOn("jsDevelopmentExecutableCompileSync")
}

tasks.named("jsDevelopmentExecutableCompileSync") {
    finalizedBy("copyPreloadJsFiles")
}
