import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.Component
import org.powbot.api.rt4.Widgets
import java.util.regex.Pattern


object Constants {
    val CONTRACT_PATTERN: Pattern =
        Pattern.compile("Amy\\|(Please could you g|G)o see (\\w*)[ ,][\\w\\s,-]*[?.] You can get another job once you have furnished \\w* home\\.")
//    private val CONTRACT_FINISHED: Pattern =
//        Pattern.compile("You have completed [\\d,]* contracts with a total of [\\d,]* points?\\.")
    private val REQUEST_CONTACT_TIER: Pattern = Pattern.compile("Could I have an? (\\w*) contract please\\?")

    val CONTRACT_QUESTION_WIDGET = Widgets.widget(217).component(6)
    val NEW_CONTRACT_WIDGET = Widgets.widget(231).component(6)
    const val SELECT_CONTRACT_WIDGET = 219
    const val SELECT_CONTRACT_COMPONENT = 1

//    val FALADOR_AREA = Area(Tile(2960, 3385, 0), Tile(2991, 3366, 0))
    val CONTRACT_AREA = Area(Tile(2988, 3367, 0), Tile(2991, 3363, 0))
    val NEW_CONTRACT_TILE = Tile(2990, 3365, 0)

    const val STEEL_BAR = 2353
    const val PLANK = 960
    const val OAK_PLANK = 8778
    const val TEAK_PLANK = 8780
    const val MAHOGANY_PLANK = 8782

    const val PORTAL = 28822


}