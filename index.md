# Kotlin/JS と Electron

Kotlin/JS で Electron を使う方法を紹介します。
Electron を使えば、Kotlin/JS でデスクトップアプリケーションを開発することができます。

現状、kotlin-wrappers で kotlin-electron が提供されていますが、kotlin-wrappers の開発チームもまだテストが出来ていない状態です。
(https://github.com/JetBrains/kotlin-wrappers/issues/2083)

よって、この記事では、気合いで Electron を使う方法を紹介します。
スマートとは言いませんが、それなりに動きます。

package.json を以下のように記述します。

<<< ./package.json{json}

```shell
npm install
node build/js/node_modules/electron/install.js
```

して、依存として electron をインストールする。

<<< ./build.gradle.kts{kotlin}

<<< ./src/jsMain/resources/index.html{html}

<<< ./src/jsMain/kotlin/Main.kt{kotlin}

ここまで実行できると、以下のようにして、コードを実行することができます。

```shell
../gradlew jsRun -t
```

```shell
./gradlew :main:jsDevelopmentExecutableCompileSync :preload:jsDevelopmentExecutableCompileSync :renderer:jsBrowserDevelopmentWebpack -t
```

## See also

- https://github.com/JetBrains/kotlin-wrappers/blob/master/kotlin-electron/README.md
- https://github.com/JetBrains/kotlin-wrappers/issues/2083
