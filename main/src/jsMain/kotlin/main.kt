import electron.BrowserWindow
import electron.app
import js.objects.jso

fun createWindow() {
    val win = BrowserWindow(jso {
        width = 800.0
        height = 600.0
        webPreferences = jso {
            preload = js("require('node:path').join(__dirname, '../preload/preload.js')") as? String
        }
        this.webPreferences?.devTools = true
    })
    win.loadFile("index.html")
}

fun main() {
    println("Starting app..., so...")
    try {
        println(app)
        app.whenReady().then {
            createWindow()
        }

        console.log("Hello Console World! darobe!YABAME!!")
    } catch (e: Throwable) {
        console.error(e)
    }
}
