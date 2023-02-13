import branch.ShouldGetContract
import homes.Homes
import leafs.Dummy
import org.powbot.api.Condition
import org.powbot.api.event.GameActionEvent
import org.powbot.api.event.MessageEvent
import org.powbot.api.event.VarpbitChangedEvent
import org.powbot.api.rt4.Objects
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.SimpleBranch
import org.powbot.api.script.tree.SimpleLeaf
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import java.util.logging.Logger
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
    override val rootComponent: TreeComponent<*> = SimpleBranch(this, "Simplebranch", SimpleLeaf(this, "") {}, Dummy(this) ) { false }//ShouldGetContract(this)
//    override val rootComponent: TreeComponent<*> = SimpleBranch(this, "Simplebranch", SimpleLeaf(this, "") {}, SimpleLeaf(this, "") { Condition.sleep(10000)} ) { false }//ShouldGetContract(this)
    val logger: Logger = Logger.getLogger(this.javaClass.simpleName)
    var currentHome: Homes? = null
    private val varbMap: HashMap<Int, Int> = HashMap()
    var contractTier: Int = 1
    val steelBars = 4

    override fun onStart() {
        addPaint()
        /**
         * TODO
         * ADD CONTRACT TIER SELECTION
         */
    }

    @com.google.common.eventbus.Subscribe
    fun varpChanged(varpEvent: VarpbitChangedEvent) {
        if (varpEvent.index == 2747)
            logger.info("varpChanged() \t Index = ${varpEvent.index} \t Old = ${varpEvent.previousValue} \t New = ${varpEvent.newValue}")
    }

    @com.google.common.eventbus.Subscribe
    fun gameAction(gameActionEvent: GameActionEvent) {
            logger.info("gameAction() Name \t = ${gameActionEvent.name} \t \t ID = ${gameActionEvent.id} \tAction = ${gameActionEvent.interaction}")
    }

    @com.google.common.eventbus.Subscribe
    fun messageReceived(msg: MessageEvent) {
        val txt = msg.message.sanitizeMultilineText()
        log.info("\n messageReceived() \n Type: ${msg.type} \n TXT: $txt")
        val matcher = Constants.CONTRACT_PATTERN.matcher(txt)
        if (matcher.matches()) {

            val location: String = matcher.group(2)
            logger.info("New task = $location")
            try {
                val home = Homes.get(location)
                log.info("New home: $home")
                currentHome = home
            } catch (e: NullPointerException) {
                log.info("Can not parse home!")
            }
        } else {
            logger.info("No matcher found with: $txt")
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

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .addString("Current Home:") { currentHome?.home ?: "Null" }
            .addString("Current Tier:") { contractTier.toString() }
            .y(45)
            .x(40)
            .build()
        addPaint(p)
    }
}

fun main() {
    Script().startScript()
//    val two = Homes.getLocation("Jess")
//    println(one?.location.toString())
//    println(one?.location?.randomTile.toString())

}