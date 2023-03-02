import org.powbot.api.Tile
import java.util.regex.Pattern


object Constants {
    val CONTRACT_PATTERN: Pattern = Pattern.compile("Amy\\|(Please could you g|G)o see (\\w*)[ ,][\\w\\s,-]*[?.] You can get another job once you have furnished \\w* home\\.")
    val CONTRACT_FINISHED: Pattern = Pattern.compile("Aaah, nothing like a nice cuppa tea!")
    val PLANK_SACK_REGEX: Pattern = Pattern.compile("Basic planks: ([0-9]+), Oak planks: ([0-9]+), Teak planks: ([0-9]+), Mahogany planks: ([0-9]+)")

    const val CONTRACT_FINISH = "Yes, I'd love a cuppa."
    const val CONTRACT_BEGINNER = "Beginner Contract"
    const val CONTRACT_NOVICE = "Novice Contract (Requires 20 Construction)"
    const val CONTRACT_ADEPT = "Adept Contract (Requires 50 Construction)"
    const val CONTRACT_EXPERT = "Expert Contract (Requires 70 Construction)"

    const val BUILD_FURNITURE_WIDGET = 458
    const val BUILD_FURNITURE_COMPONENT = 4

    val NEW_CONTRACT_TILE = Tile(2990, 3365, 0)
    val BANK_TILE = Tile(3012, 3355, 0)

    const val STEEL_BAR = 2353
    const val PLANK = 960
    const val OAK_PLANK = 8778
    const val TEAK_PLANK = 8780
    const val MAHOGANY_PLANK = 8782

    const val HAMMER = 2347
    const val SAW = 8794
    const val AMYS_SAW = 24880
    const val PLANK_SACK = 24882

    val FURNITURE_VARPS = intArrayOf(10554, 10555, 10556, 10557, 10558, 10559, 10560, 10561)
}