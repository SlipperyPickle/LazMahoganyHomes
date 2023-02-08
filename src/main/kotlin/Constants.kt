import java.util.regex.Pattern

object Constants {
    val CONTRACT_PATTERN: Pattern =
        Pattern.compile("Amy\\|(Please could you g|G)o see (\\w*)[ ,][\\w\\s,-]*[?.] You can get another job once you have furnished \\w* home\\.")
    private val CONTRACT_FINISHED: Pattern =
        Pattern.compile("You have completed [\\d,]* contracts with a total of [\\d,]* points?\\.")
    private val REQUEST_CONTACT_TIER: Pattern = Pattern.compile("Could I have an? (\\w*) contract please\\?")

}