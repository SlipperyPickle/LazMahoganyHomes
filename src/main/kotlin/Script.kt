import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.TEAK_PLANK
import Constants.WRONG_CONTRACT
import branch.HasContract
import homes.Homes
import org.powbot.api.Notifications
import org.powbot.api.event.InventoryChangeEvent
import org.powbot.api.event.MessageEvent
import org.powbot.api.event.SkillExpGainedEvent
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
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
    version = "1.0.1",
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
            name = "Amys saw",
            description = "Would you like to use Amys saw?",
            optionType = OptionType.BOOLEAN,
            defaultValue = "false"
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

    var currentHome: Homes? = null
    var currentTier by Delegates.notNull<Int>()
    private var currentTierString = ""
    var steelBars = 2
    var plankSackNumber: Int = -1
    var usePlankSack = true
    var amysSaw = false

    override fun onStart() {
        addPaint()
        currentTier = when (getOption<String>("Tier")) {
            "Beginner" -> 0
            "Novice" -> 1
            "Adept" -> 2
            "Expert" -> 3
            else -> -1
        }
        currentTierString = getOption<String>("Tier")
        usePlankSack = getOption<Boolean>("Use planksack")
        steelBars = getOption<Int>("Steel bars")
        amysSaw = getOption<Boolean>("Amys saw")
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
        if (!usePlankSack || !Bank.opened()) {
            return
        }

        if (inventoryChangeEvent.itemId != PLANK &&
            inventoryChangeEvent.itemId != OAK_PLANK &&
            inventoryChangeEvent.itemId != TEAK_PLANK &&
            inventoryChangeEvent.itemId != MAHOGANY_PLANK) {
            return
        }

        if (inventoryChangeEvent.quantityChange in -28..-1) {
            logger("inventoryChangeEvent", "Change of ${inventoryChangeEvent.itemName} number: " +
                    "${inventoryChangeEvent.quantityChange}")
            plankSackNumber += -inventoryChangeEvent.quantityChange
        }
    }

    @com.google.common.eventbus.Subscribe
    fun xpGainedEvent(xp: SkillExpGainedEvent) {
        if (xp.skill != Skill.Construction) {
            return
        }
        when (currentTier) {
            0 -> {
                plankSackNumber = when (xp.expGained) {
                    in 21..25, in 127..134 -> plankSackNumber - 1
                    in 42..49 -> plankSackNumber - 2
                    in 65..71 -> plankSackNumber - 3
                    in 88..91 -> plankSackNumber - 4
                    else -> plankSackNumber
                }
            }

            1 -> {
                plankSackNumber = when (xp.expGained) {
                    in 47..51, in 159..166 -> plankSackNumber - 1
                    in 94..101 -> plankSackNumber - 2
                    in 142..150 -> plankSackNumber - 3
                    in 190..199 -> plankSackNumber - 4
                    else -> plankSackNumber
                }
            }

            2 -> {
                plankSackNumber = when (xp.expGained) {
                    in 71..75, in 189..196 -> plankSackNumber - 1
                    in 142..150 -> plankSackNumber - 2
                    in 214..224 -> plankSackNumber - 3
                    in 290..298 -> plankSackNumber - 4
                    else -> plankSackNumber
                }
            }

            3 -> {
                plankSackNumber = when (xp.expGained) {
                    in 110..117, in 238..248 -> plankSackNumber - 1
                    in 222..232 -> plankSackNumber - 2
                    in 334..348 -> plankSackNumber - 3
                    in 446..461 -> plankSackNumber - 4
                    else -> plankSackNumber
                }
            }
        }
    }

    @com.google.common.eventbus.Subscribe
    fun messageReceived(msg: MessageEvent) {
        val txt = msg.message.sanitizeMultilineText().replace(" ", " ")

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
        }

        if (txt.startsWith("Basic")) {
            val plankArray = txt.replace(" ", "").split(",").map { it.replace("[^\\d.]".toRegex(), "").toInt() }
            plankSackNumber = plankArray[currentTier] + Inventory.stream().id(*intArrayOf(PLANK, OAK_PLANK, TEAK_PLANK, MAHOGANY_PLANK)).count().toInt()
            logger("messageReceived", "Plank array = ${txt.replace(" ", "").split(",").map { it.replace("[^\\d.]".toRegex(), "")}}")
        }
        val matcherWrongContract = WRONG_CONTRACT.matcher(txt)
        if (matcherWrongContract.matches()) {
            logger("messageReceived", "Pow selected the wrong contract, stopping.")
            Notifications.showNotification("Pow selected the wrong contract, stopping.")
            ScriptManager.stop()
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
//                    .replace(" ".toRegex(), " ")

            )
        }
    }

    private fun addPaint() {
        if (usePlankSack) {
            val p: Paint = PaintBuilder.newBuilder()
                .trackSkill(Skill.Construction)
                .addString("Last leaf:") { lastLeaf.name }
                .addString("Current home:") { currentHome?.home ?: "Null" }
                .addString("Current tier:") { currentTierString }
                .addString("Furniture left:") { Homes.furnitureLeft().toString() }
                .addString("Total planks:") { plankSackNumber.toString() }
                .y(45)
                .x(40)
                .build()
            addPaint(p)
        } else {
            val p: Paint = PaintBuilder.newBuilder()
                .trackSkill(Skill.Construction)
                .addString("Last leaf:") { lastLeaf.name }
                .addString("Current home:") { currentHome?.home ?: "Null" }
                .addString("Current Tier:") { currentTierString }
                .addString("Furniture left:") { Homes.furnitureLeft().toString() }
                .y(45)
                .x(40)
                .build()
            addPaint(p)
        }
    }

    fun logger(name: String, message: String) {
        val logger = Logger.getLogger(name)
        logger.info("[${name.uppercase()}] $message")
    }
}

fun main() {
    Script().startScript()


}