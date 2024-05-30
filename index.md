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
    - preload.js            # Preload script for Electron

  - main                    # Kotlin/JS code for the main process  
    - build.gradle.kts
    - src/jsMain/kotlin/main.kt
  - renderer                 # Kotlin/JS code for the renderer process  
    - build.gradle.kts
    - src/jsMain/kotlin/renderer.kt
```

- main module configures the main process of Electron.
- renderer module configures the renderer process of Electron.

On each module, Kotlin/JS code is written in `src/jsMain/kotlin` directory.

You need to run the following command to build the Electron application.

```shell
./debug.py
```

It compiles Kotlin/JS code and copy it to the target directory by custom gradle task.

## Remaining tasks...

- use React with kotlin-js
- expose node functions to renderer process

## See also

- https://github.com/JetBrains/kotlin-wrappers/blob/master/kotlin-electron/README.md
- https://github.com/JetBrains/kotlin-wrappers/issues/2083
