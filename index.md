# Sample code of the Kotlin/JS and Electron

This article introduces how to use Electron with Kotlin/JS.
With Electron, you can develop desktop applications with Kotlin/JS.

Currently, kotlin-wrappers provides kotlin-electron, but the development team of kotlin-wrappers has not yet tested it.
And there is no sample code around it.
(https://github.com/JetBrains/kotlin-wrappers/issues/2083)

Therefore, this article introduces how to use Electron with Kotlin/JS by force.
It's not so smart, but it's a way to use Electron with Kotlin/JS.

## Environment

This sample code has a following directory structure.

```
  - build.gradle.kts        # Gradle configuration
  - settings.gradle.kts
  - gradlew/                # Gradle wrapper
  - gradle.properties

  - target/                 # build directory for Electron
    - package.json          # Configuation for Electron
    - index.html            # HTML file for Electron

  - main                    # Kotlin/JS code for the main process  
    - build.gradle.kts
    - src/jsMain/kotlin/main.kt
  - preload                 # Kotlin/JS code for the preload process  
    - build.gradle.kts
    - src/jsMain/kotlin/preload.kt
  - renderer                 # Kotlin/JS code for the renderer process  
    - build.gradle.kts
    - src/jsMain/kotlin/renderer.kt
```

- main module configures the main process of Electron.
- preload module configures the preload process of Electron.
- renderer module configures the renderer process of Electron.

On each module, Kotlin/JS code is written in `src/jsMain/kotlin` directory.

You need to run the following command to build the Electron application.

```shell
./gradlew jsDevelopmentExecutableCompileSync -t
```

It compiles Kotlin/JS code and copy it to the target directory by custom gradle task.
By `-t` option, it watches the changes of the Kotlin/JS code and recompile it.

## run electron command

After that, run the electron app!

```shell
cd target
npm install
npx electron .
```

## See also

- https://github.com/JetBrains/kotlin-wrappers/blob/master/kotlin-electron/README.md
- https://github.com/JetBrains/kotlin-wrappers/issues/2083
