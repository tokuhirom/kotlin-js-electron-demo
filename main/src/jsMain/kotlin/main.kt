import electron.app
import electron.core.AppEvent
import electron.ipcMain
import electron.BrowserWindow
import js.objects.jso

//@Suppress("ObjectPropertyName")
//external val __dirname: dynamic

fun createWindow() {
    val win = BrowserWindow(jso {
        width = 800.0
        height = 600.0
        webPreferences = jso {
            preload = js("(import.meta.dirname) + '/../preload/preload.js'") as String?
//            preload = js("require('node:path').join(__dirname, '../preload/preload.mjs')") as String?
//            preload = path.join(__dirname as String, "../preload/preload.mjs")
        }
        this.webPreferences?.devTools = true
    })
    win.loadFile("index.html")
}

fun main() {
    println("Starting app...")
    try {
        println(app)
        app.whenReady().then {
            ipcMain.handle("ping") {
                "pong"
            }

            createWindow()

            app.on(AppEvent.ACTIVATE) { _, _ ->
                if (js("BrowserWindow.getAllWindows().length == 0") as Boolean) {
                    createWindow()
                }
            }
        }

        app.on(AppEvent.WINDOW_ALL_CLOSED) {
            if (js("process.platform") != "darwin") {
                app.quit()
            }
        }

        console.log("Completed app initialization!");
    } catch (e: Throwable) {
        console.error(e)
    }

}
