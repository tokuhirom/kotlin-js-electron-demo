import electron.contextBridge
import js.objects.jso

external interface MyApi {
    var node: String
//    var ping: () -> Promise<Any?>
}

fun main() {
    val myApi : MyApi = jso {
        node = js("process.versions.node") as String
//        ping = { ipcRenderer.invoke("ping") }
    }
    console.log("Loading preload script...")
    contextBridge.exposeInMainWorld("versions", myApi)
}
