import branch.FirstBranch
import homes.Homes
import org.powbot.api.event.MessageEvent
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import java.util.logging.Logger
import java.util.regex.Matcher
import java.util.regex.Pattern

@ScriptManifest(
    name = "LazMahoganyHomes",
    description = "Mahogany Homes",
    version = "1.0.0",
    category = ScriptCategory.Construction,
    author = "Lazarus",
    markdownFileName = "MahoganyHomes.md"
)


class Script : TreeScript() {
    override val rootComponent: TreeComponent<*> = FirstBranch(this)
    val logger: Logger = Logger.getLogger(this.javaClass.simpleName)
    var currentHome: Homes? = null

    override fun onStart() {
        addPaint()
    }

    @com.google.common.eventbus.Subscribe
    fun messageReceived(msg: MessageEvent) {
        val txt = msg.message.sanitizeMultilineText()
        log.info("\n messageReceived() \n Type: ${msg.type} \n TXT: $txt")
        val matcher = Constants.CONTRACT_PATTERN.matcher(txt)
        if (matcher.matches()) {

            val location: String = matcher.group(2)
            logger.info("New task = $location")
//            setHome(matcher)
        } else {
            logger.info("No matcher with $txt")
        }
    }

    /**
     * Credits to Krulvis
     */

    companion object {
        private val TAG_REGEXP = Pattern.compile("<[^>]*>")

        private fun removeTags(str: String): String {
            return TAG_REGEXP.matcher(str).replaceAll("")
        }

        fun String.sanitizeMultilineText(): String {
            return removeTags(
                replace("-<br>".toRegex(), "-")
                    .replace("<br>".toRegex(), " ")
                    .replace("[ ]+".toRegex(), " ")
            )
        }
    }

//    fun setHome(matcher: Matcher) {
//        log.info("Parsing task: $matcher")
//
//        try {
//            val home = Homes.currentHome(matcher.group(2))
//            log.info("New home: $home")
////            currentHome = home
//        } catch (e: NullPointerException) {
//            log.info("Can not parse home!")
//        }
//    }

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .addString("Current Home:") { currentHome?.name ?: "Null" }
            .y(45)
            .x(40)
            .build()
        addPaint(p)
    }
}

fun main() {
    Script().startScript()

    val one = Homes.get("Jess")

//    val two = Homes.getLocation("Jess")
//    println(one?.location.toString())
//    println(one?.location?.randomTile.toString())

}