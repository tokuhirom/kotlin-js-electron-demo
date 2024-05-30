import electron.contextBridge
import js.objects.jso
import node.process.process

external interface MyApi {
    var node: String
}

fun main() {
    val myApi : MyApi = jso {
        node = process.versions.node
    }
    contextBridge.exposeInMainWorld("versions", myApi)
}
