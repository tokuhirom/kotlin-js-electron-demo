import kotlinx.browser.document
import web.timers.setInterval
import kotlin.time.Duration.Companion.seconds

fun main() {
    val hoge = Hoge("hoge", 33)
    document.getElementById("root")?.let {root ->
        setInterval(1.seconds) {
            println("invoked timer...")
            val div = document.createElement("div")
            div.textContent = "Hello, World! WOWYAY!! AGGKOKO $hoge"
            root.appendChild(div)
        }
    }
    println("Hello, electron World! $hoge!! mjs!! ん?ほげ")
}
