import homes.Homes
import leafs.Dummy
import org.powbot.api.event.MessageEvent
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
//    override val rootComponent: TreeComponent<*> = SimpleBranch(this, "Simplebranch", SimpleLeaf(this, "") {}, SimpleLeaf(this, "") { logger.info("In home: ${Homes.inCurrentHome("Mariah")}"); Condition.sleep(10000)} ) { false }//ShouldGetContract(this)
    val logger: Logger = Logger.getLogger(this.javaClass.simpleName)
    var currentHome: Homes? = Homes.get("Mariah")// null
    var contractTier: Int = 3 //1-4
    val steelBars = 4

    override fun onStart() {
        addPaint()
        /**
         * TODO
         * ADD CONTRACT TIER SELECTION
         */
    }

//    @com.google.common.eventbus.Subscribe
//    fun varpChanged(varpEvent: VarpbitChangedEvent) {
//
//        if (varpEvent.index == 2747)
//            logger.info("varpChanged() \t Index = ${varpEvent.index} \t Old = ${varpEvent.previousValue} \t New = ${varpEvent.newValue}")
//    }
//
//    @com.google.common.eventbus.Subscribe
//    fun gameAction(gameActionEvent: GameActionEvent) {
//        if (currentHome != null) {
//            logger.info(
//                "gameAction() \n" +
//                        "Home: \t   ${currentHome?.home} \n" +
//                        "Name: \t     ${gameActionEvent.name} \n" +
//                        "ID: \t     ${gameActionEvent.id} \n"
//            )
//        }
//    }

//    @com.google.common.eventbus.Subscribe
//    fun onRender(r: RenderEvent) {
//
//        Rendering.setScale(1.0f);
//        Rendering.setColor(Color.BLACK)
//        logger.info(objects!!.toList().toString())
//        if (objects!!.isNotEmpty()) {
//            objects!!.first().draw()
//        }
//    }
//
//    override fun poll() {
//        val actions = arrayOf("Repair", "Remove", "Build")
//        val objects = Objects.stream().action(*actions).nearest()
//        for (obj in objects) {
//            logger.info("name = ${obj.name} \n" +
//                    "id = ${obj.id()} \n" +
//                    "mi = ${obj.mainId()}")
//        }
//        super.poll()
//    }

    @com.google.common.eventbus.Subscribe
    fun messageReceived(msg: MessageEvent) {
        val txt = msg.message.sanitizeMultilineText()
        log.info("\n messageReceived() \n Type: ${msg.type} \n TXT: $txt")
        val matcherStart = Constants.CONTRACT_PATTERN.matcher(txt)
        if (matcherStart.matches()) {

            val location: String = matcherStart.group(2)
            logger.info("New task = $location")
            try {
                val home = Homes.get(location)
                log.info("New home: $home")
                currentHome = home
            } catch (e: NullPointerException) {
                log.info("Can not parse home!")
            }
        } else {
            logger.info("No new task found with: $txt")
        }

        val matcherFinished = Constants.CONTRACT_FINISHED.matcher(txt)
        if (matcherFinished.matches()) {
            logger.info("Task finished")
            currentHome = null
        }
    }

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