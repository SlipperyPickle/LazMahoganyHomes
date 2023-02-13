package homes

import Constants
import org.powbot.api.Area
import org.powbot.api.Tile


enum class Homes(
    val home: String,
    val location: Tile,
    val requiredItems: RequiredItems
) {
    JESS(
        "Jess",
        Tile(2621, 3293, 1),
        RequiredItems.JESS
    ),

    NOELLA(
        "Noella",
        Tile(2659, 3321, 0),
        RequiredItems.NOELLA
    ),

    ROSS(
        "Ross",
        Tile(2614, 3317, 0),
        RequiredItems.ROSS
    ),

    LARRY(
        "Larry",
        Tile(3037, 3363, 0),
        RequiredItems.LARRY
    ),

    NORMAN(
        "Norman",
        Tile(3037, 3345, 1),
        RequiredItems.NORMAN
    ),

    TAU(
        "Tau",
        Tile(3046, 3346, 0),
        RequiredItems.TAU
    ),

    BARBARA(
        "Barbara",
        Tile(1749, 3534, 0),
        RequiredItems.BARBARA
    ),

    LEELA(
        "Leela",
        Tile(1785, 3593, 0),
        RequiredItems.LEELA
    ),

    MARIAH(
        "Mariah",
        Tile(1765, 3621, 0),
        RequiredItems.MARIAH
    ),

    BOB(
        "Bob",
        Tile(3239, 3486, 0),
        RequiredItems.BOB
    ),

    JEFF(
        "Jeff",
        Tile(3240, 3451, 0),
        RequiredItems.JEFF
    ),

    SARAH(
        "Sarah",
        Tile(3234, 3384, 0),
        RequiredItems.SARAH
    );

    companion object {
        fun get(name: String): Homes? = Homes.values().firstOrNull { it.name.equals(name, true) }

        fun location(name: String): Tile? = Homes.values().firstOrNull { it.name.equals(name, true) }?.location


    }



//    fun location(locationText: String): Location {
//        val text = locationText.replace(" ", "_")
//        val parsedLocation = locations.firstOrNull { it.dungeon.name.equals(text, true) }
//        if (parsedLocation == null) {
//            ScriptManager.script()?.log?.info("Couldn't parse location: $text")
//            return locations.first()
//        }
//        return parsedLocation
//    }
}

enum class RequiredItems(
    val beginner: Array<Int>,
    val novice: Array<Int>,
    val adept: Array<Int>,
    val expert: Array<Int>,
) {

    /**
     *  EAST ARDOUGNE
     */

    JESS(
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(15, 1),
        arrayOf(15, 1)
    ),

    NOELLA(
        arrayOf(12, 0),
        arrayOf(12, 0),
        arrayOf(15, 0),
        arrayOf(15, 0)
    ),

    ROSS(
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(11, 1)
    ),

    /**
     *  FALADOR
     */

    LARRY(
        arrayOf(12, 1),
        arrayOf(12, 1),
        arrayOf(12, 1),
        arrayOf(12, 1)
    ),

    NORMAN(
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(13, 1),
        arrayOf(13, 1)
    ),

    TAU(
        arrayOf(12, 1),
        arrayOf(12, 1),
        arrayOf(13, 1),
        arrayOf(13, 1)
    ),

    /**
     * HOSIDIUS
     */

    BARBARA(
        arrayOf(8, 1),
        arrayOf(8, 1),
        arrayOf(10, 1),
        arrayOf(13, 1)
    ),

    LEELA(
        arrayOf(9, 1),
        arrayOf(9, 1),
        arrayOf(10, 1),
        arrayOf(13, 1)
    ),

    MARIAH(
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(14, 1),
        arrayOf(14, 1)
    ),

    /**
     * VARROCK
     */

    BOB(
        arrayOf(14, 0),
        arrayOf(14, 0),
        arrayOf(17, 0),
        arrayOf(17, 0)
    ),

    JEFF(
        arrayOf(13, 0),
        arrayOf(13, 0),
        arrayOf(16, 0),
        arrayOf(16, 0)
    ),

    SARAH(
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(11, 1),
        arrayOf(11, 1),
    );

    companion object {
        fun get(name: String, tier: Int): Array<Int>? {
            val tiers = values().firstOrNull { it.name.equals(name, true) }
            when (tier) {
                0 -> return tiers?.beginner
                1 -> return tiers?.novice
                2 -> return tiers?.adept
                3 -> return tiers?.expert
            }
            return null
        }

        fun getPlank(tier: Int): Int {
            when (tier) {
                0 -> return Constants.PLANK
                1 -> return Constants.OAK_PLANK
                2 -> return Constants.TEAK_PLANK
                3 -> return Constants.MAHOGANY_PLANK
            }
            return -1
        }
    }







//    fun furniture(): GameObject? {
//        return Objects.stream().id(*allObjects)
//            .reachable()
//            .nearest()
//            .firstOrNull()
//    }
}