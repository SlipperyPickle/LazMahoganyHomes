//import leafs.Dummy
import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.TEAK_PLANK
import branch.HasContract
import homes.Homes
import org.powbot.api.event.InventoryChangeEvent
import org.powbot.api.event.MessageEvent
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.OptionType
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptConfiguration
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.dax.api.DaxWalker
import org.powbot.dax.teleports.Teleport
import org.powbot.mobile.script.ScriptManager
import java.util.logging.Logger
import java.util.regex.Pattern
import kotlin.properties.Delegates

@ScriptManifest(
    name = "LazMahoganyHomes",
    description = "Mahogany Homes",
    version = "1.0.0",
    category = ScriptCategory.Construction,
    author = "Lazarus",
    markdownFileName = "MahoganyHomes.md"
)

@ScriptConfiguration.List(
    [
        ScriptConfiguration(
            name = "Tier",
            description = "Select the tier you would like to use.",
            optionType = OptionType.STRING,
            allowedValues = arrayOf("Beginner", "Novice", "Adept", "Expert")
        ),
        ScriptConfiguration(
            name = "Use planksack",
            description = "Would you like to use a PlankSack?",
            optionType = OptionType.BOOLEAN
        ),
        ScriptConfiguration(
            name = "Steel bars",
            description = "Number of steel bars to use.",
            optionType = OptionType.INTEGER,
            defaultValue = "2"
        )
    ]
)

class Script : TreeScript() {
        override val rootComponent: TreeComponent<*> = HasContract(this)
//    override val rootComponent: TreeComponent<*> = SimpleBranch(this, "Simplebranch", SimpleLeaf(this, "") {}, Dummy(this) ) { false }//ShouldGetContract(this)


    var currentHome: Homes? = null
    var firstFloorDone: Boolean = false
    var currentTier by Delegates.notNull<Int>()
    var steelBars = 2
    var plankSackNumber: Int = -1
    var usePlankSack = true
    val amysSaw = false
//    val currentFurniture = Ross.AllRoss.toMutableList()

    override fun onStart() {
        addPaint()
        currentTier = when (getOption<String>("Tier")) {
            "Beginner" -> 0
            "Novice" -> 1
            "Adept" -> 2
            "Expert" -> 3
            else -> -1
        }
        usePlankSack = getOption<Boolean>("Use planksack")
        steelBars = getOption<Int>("Steel bars")
        DaxWalker.removeBlacklistTeleports(
            Teleport.POH_OUTSIDE_HOSIDIUS,
            Teleport.POH_OUTSIDE_HOSIDIUS_TAB,
            Teleport.VARROCK_TELEPORT,
            Teleport.VARROCK_TELEPORT_TAB,
            Teleport.FALADOR_TELEPORT,
            Teleport.FALADOR_TELEPORT_TAB,
            Teleport.ARDOUGNE_TELEPORT,
            Teleport.ARDOUGNE_TELEPORT_TAB
        )
    }

    @com.google.common.eventbus.Subscribe
    fun inventoryChangedEvent(inventoryChangeEvent: InventoryChangeEvent) {
        if (!usePlankSack) { //|| Bank.opened()
            return
        }
        if (inventoryChangeEvent.itemId != PLANK &&
            inventoryChangeEvent.itemId != OAK_PLANK &&
            inventoryChangeEvent.itemId != TEAK_PLANK &&
            inventoryChangeEvent.itemId != MAHOGANY_PLANK) {
            return
        }

        val logger: Logger = Logger.getLogger(this.javaClass.simpleName)
        logger.info("Change of ${inventoryChangeEvent.itemName} number: ${inventoryChangeEvent.quantityChange}")

        if (Bank.opened()) {
            if (inventoryChangeEvent.quantityChange in -28 .. -5) {
                plankSackNumber += -inventoryChangeEvent.quantityChange
            }
        } else {
            if (inventoryChangeEvent.quantityChange in 5 .. 28) {
                plankSackNumber += -inventoryChangeEvent.quantityChange
            }
        }


//        when (inventoryChangeEvent.quantityChange) {
//            in -4 .. 4 -> {}
//            in 5..28 -> plankSackNumber += -inventoryChangeEvent.quantityChange
//            in -28..-5 -> plankSackNumber += -inventoryChangeEvent.quantityChange
//
//        }
    }

    @com.google.common.eventbus.Subscribe
    fun messageReceived(msg: MessageEvent) {
        val txt = msg.message.sanitizeMultilineText()

        val matcherStart = Constants.CONTRACT_PATTERN.matcher(txt)
        if (matcherStart.matches()) {

            val location: String = matcherStart.group(2)
            try {
                val home = Homes.get(location)
                logger("messageReceived", "New home = $home")
                currentHome = home
            } catch (e: NullPointerException) {
                logger("messageReceived", "Can not parse home!")
                ScriptManager.stop()
            }
        } else {
            logger("messageReceived", "No new task found with: $txt")
        }

        val matcherFinished = Constants.CONTRACT_FINISHED.matcher(txt)
        if (matcherFinished.matches()) {
            logger("messageReceived", "Task finished")
            currentHome = null
            firstFloorDone = false
        }

        val matcherPlankSack = Constants.PLANK_SACK_REGEX.matcher(txt)

        if (matcherPlankSack.matches()) {
            plankSackNumber = matcherPlankSack.group(currentTier + 1).toInt()
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
        if (usePlankSack) {
            val p: Paint = PaintBuilder.newBuilder()
                .trackSkill(Skill.Construction)
                .addString("Last leaf:") { lastLeaf.name }
                .addString("Current Home:") { currentHome?.home ?: "Null" }
                .addString("Furniture left:") { Homes.furnitureLeft().toString() }
                .addString("Current Tier:") { currentTier.toString() }
                .addString("PlankSack:") { plankSackNumber.toString() }
                .y(45)
                .x(40)
                .build()
            addPaint(p)
        } else {
            val p: Paint = PaintBuilder.newBuilder()
                .trackSkill(Skill.Construction)
                .addString("Last leaf:") { lastLeaf.name }
                .addString("Current Home:") { currentHome?.home ?: "Null" }
                .addString("Furniture left:") { Homes.furnitureLeft().toString() }
                .addString("Current Tier:") { currentTier.toString() }
                .y(45)
                .x(40)
                .build()
            addPaint(p)
        }
    }

    fun logger(name: String, message: String) {
        val logger = Logger.getLogger(name)
        logger.info(message)
    }


}

fun main() {
    Script().startScript()
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