plugins {
    kotlin("multiplatform") version "2.0.0"
}

kotlin {
    js {
        moduleName = "main"
        nodejs {
        }
        useEsModules()
        binaries.executable()
    }
    sourceSets {
        val commonMain by getting {
        }
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.754"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-electron")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-node")
            }
        }
    }
}

// copy built files into target/main/
tasks.register<Copy>("copyJsFiles") {
    group = "custom"
    description = "Copy JS files to target directory after compileSync"

    from(projectDir.resolve("build/compileSync/js/main/developmentExecutable/kotlin"))
    into(rootDir.resolve("target/main/"))

    dependsOn("jsDevelopmentExecutableCompileSync")
}

tasks.named("jsDevelopmentExecutableCompileSync") {
    finalizedBy("copyJsFiles")
}
