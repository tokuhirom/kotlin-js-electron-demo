plugins {
    kotlin("multiplatform") version "2.0.0"
}

kotlin {
    js {
        moduleName = "renderer"
        browser()
        useEsModules()
        binaries.executable()
    }
    sourceSets {
        val jsMain by getting {
            dependencies {
                implementation(project.dependencies.platform("org.jetbrains.kotlin-wrappers:kotlin-wrappers-bom:1.0.0-pre.754"))
                implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react")
                implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom")
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

// Copy built files into target/renderer/
tasks.register<Copy>("copyJsFiles") {
    group = "custom"
    description = "Copy JS files to target directory after compileSync"

    from(projectDir.resolve("build/compileSync/js/main/developmentExecutable/kotlin"))
    into(rootDir.resolve("target/renderer/"))

    dependsOn("jsDevelopmentExecutableCompileSync")
}

tasks.named("jsDevelopmentExecutableCompileSync") {
    finalizedBy("copyJsFiles")
}
