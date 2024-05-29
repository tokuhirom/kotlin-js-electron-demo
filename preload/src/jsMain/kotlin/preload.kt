import electron.contextBridge
import js.objects.jso

external interface MyApi {
    var node: String
}

fun main() {
    val myApi : MyApi = jso {
        node = "process.versions.node!ZANSU!"
    }
    contextBridge.exposeInMainWorld("versions", myApi)
}
