import electron.BrowserWindow
import electron.app
import electron.core.AppEvent
import electron.ipcMain
import js.objects.jso
import node.path.path
import node.process.Platform
import node.process.process

//@Suppress("ObjectPropertyName")
//external val __dirname: dynamic

fun createWindow() {
    val win = BrowserWindow(jso {
        width = 800.0
        height = 600.0
        webPreferences = jso {
            preload = path.join(js("(import.meta.dirname)") as String, "/../preload.js")
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
//                if (BrowserWindow.getAllWindows().isEmpty()) {
//                    createWindow()
//                }
                if (js("BrowserWindow.getAllWindows().length == 0") as Boolean) {
                    createWindow()
                }
            }
        }

        app.on(AppEvent.WINDOW_ALL_CLOSED) {
            if (process.platform != Platform.darwin) {
                app.quit()
            }
        }

        console.log("Completed app initialization!");
    } catch (e: Throwable) {
        console.error(e)
    }

}
