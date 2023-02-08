package homes

import org.powbot.api.Area
import org.powbot.api.Tile


enum class HomesOld(
    val home: String,
    val location: Area,
    val requiredItems: RequiredItems
) {
    JESS(
        "Jess",
        Area(
            Tile(2619, 3295, 0),
            Tile(2624, 3290, 0)
        ),
        RequiredItems.JESS
    ),

    NOELLA(
        "Noella",
        Area(
            Tile(2653, 3323, 0),
            Tile(2661, 3323, 0),
            Tile(2661, 3324, 0),
            Tile(2666, 3324, 0),
            Tile(2666, 3320, 0),
            Tile(2661, 3320, 0),
            Tile(2661, 3321, 0),
            Tile(2658, 3321, 0),
            Tile(2658, 3320, 0),
            Tile(2657, 3319, 0),
            Tile(2654, 3319, 0),
            Tile(2653, 3320, 0)
        ),
        RequiredItems.NOELLA
    ),

    ROSS(
        "Ross",
        Area(
            Tile(2617, 3315, 0),
            Tile(2611, 3318, 0)
        ),
        RequiredItems.ROSS
    ),

    LARRY(
        "Larry",
        Area(
            Tile(3042, 3368, 0),
            Tile(3037, 3368, 0),
            Tile(3037, 3365, 0),
            Tile(3034, 3365, 0),
            Tile(3034, 3362, 0),
            Tile(3042, 3362, 0)
        ),
        RequiredItems.LARRY
    ),

    NORMAN(
        "Norman",
        Area(
            Tile(3041, 3347, 0),
            Tile(3035, 3347, 0),
            Tile(3035, 3344, 0),
            Tile(3036, 3344, 0),
            Tile(3036, 3342, 0),
            Tile(3041, 3342, 0)
        ),
        RequiredItems.NORMAN
    ),

    TAU(
        "Tau",
        Area(
            Tile(3052, 3350, 0),
            Tile(3048, 3350, 0),
            Tile(3044, 3346, 0),
            Tile(3044, 3343, 0),
            Tile(3046, 3343, 0),
            Tile(3046, 3341, 0),
            Tile(3050, 3341, 0),
            Tile(3050, 3347, 0),
            Tile(3052, 3347, 0)
        ),
        RequiredItems.TAU
    ),

    BARBARA(
        "Barbara",
        Area(
            Tile(1750, 3540, 0),
            Tile(1747, 3540, 0),
            Tile(1747, 3532, 0),
            Tile(1755, 3532, 0),
            Tile(1755, 3536, 0),
            Tile(1750, 3536, 0)
        ),
        RequiredItems.BARBARA
    ),

    LEELA(
        "Leela",
        Area(
            Tile(1788, 3595, 0),
            Tile(1783, 3595, 0),
            Tile(1782, 3594, 0),
            Tile(1782, 3590, 0),
            Tile(1789, 3590, 0),
            Tile(1789, 3594, 0)
        ),
        RequiredItems.LEELA
    ),

    MARIAH(
        "Mariah",
        Area(
            Tile(1771, 3624, 0),
            Tile(1764, 3624, 0),
            Tile(1763, 3623, 0),
            Tile(1763, 3620, 0),
            Tile(1764, 3619, 0),
            Tile(1768, 3619, 0),
            Tile(1769, 3620, 0),
            Tile(1769, 3621, 0),
            Tile(1771, 3621, 0)
        ),
        RequiredItems.MARIAH
    ),

    BOB(
        "Bob",
        Area(
            Tile(3242, 3491, 0),
            Tile(3235, 3491, 0),
            Tile(3235, 3483, 0),
            Tile(3242, 3483, 0)
        ),
        RequiredItems.BOB
    ),

    JEFF(
        "Jeff",
        Area(
            Tile(3243, 3455, 0),
            Tile(3237, 3455, 0),
            Tile(3237, 3454, 0),
            Tile(3236, 3453, 0),
            Tile(3236, 3452, 0),
            Tile(3237, 3451, 0),
            Tile(3237, 3450, 0),
            Tile(3236, 3449, 0),
            Tile(3236, 3448, 0),
            Tile(3237, 3447, 0),
            Tile(3237, 3446, 0),
            Tile(3243, 3446, 0),
            Tile(3243, 3447, 0),
            Tile(3244, 3448, 0),
            Tile(3244, 3449, 0),
            Tile(3243, 3450, 0),
            Tile(3243, 3451, 0),
            Tile(3244, 3452, 0),
            Tile(3244, 3453, 0),
            Tile(3243, 3454, 0)
        ),
        RequiredItems.JEFF
    ),

    SARAH(
        "Sarah",
        Area(
            Tile(3239, 3387, 0),
            Tile(3230, 3387, 0),
            Tile(3230, 3382, 0),
            Tile(3239, 3382, 0)
        ),
        RequiredItems.SARAH
    );



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
        arrayOf(9, 11, 0, 1),
        arrayOf(9, 11, 0, 1),
        arrayOf(12, 15, 0, 1),
        arrayOf(14, 15, 0, 1)
    ),

    NOELLA(
        arrayOf(11, 12, 0, 0),
        arrayOf(11, 12, 0, 0),
        arrayOf(12, 15, 0, 0),
        arrayOf(13, 15, 0, 0)
    ),

    ROSS(
        arrayOf(8, 11, 0, 1),
        arrayOf(8, 11, 0, 1),
        arrayOf(8, 11, 1, 1),
        arrayOf(10, 11, 0, 1)
    ),

    /**
     *  FALADOR
     */

    LARRY(
        arrayOf(8, 12, 0, 1),
        arrayOf(8, 12, 0, 1),
        arrayOf(9, 12, 0, 1),
        arrayOf(12, 12, 0, 1)
    ),

    NORMAN(
        arrayOf(11, 11, 0, 1),
        arrayOf(10, 11, 0, 1),
        arrayOf(10, 13, 0, 1),
        arrayOf(12, 13, 0, 1)
    ),

    TAU(
        arrayOf(8, 12, 0, 1),
        arrayOf(8, 12, 0, 1),
        arrayOf(9, 13, 0, 1),
        arrayOf(12, 13, 0, 1)
    ),

    /**
     * HOSIDIUS
     */

    BARBARA(
        arrayOf(3, 8, 0, 1),
        arrayOf(3, 8, 0, 1),
        arrayOf(9, 10, 0, 1),
        arrayOf(12, 13, 0, 1)
    ),

    LEELA(
        arrayOf(8, 9, 0 , 1),
        arrayOf(8, 9, 0 , 1),
        arrayOf(9, 10, 0, 1),
        arrayOf(12, 13, 0, 1)
    ),

    MARIAH(
        arrayOf(7, 11, 0, 1),
        arrayOf(7, 11, 0, 1),
        arrayOf(11, 14, 0, 1),
        arrayOf(13, 14, 0, 1)
    ),

    /**
     * VARROCK
     */

    BOB(
        arrayOf(13, 14, 0, 0),
        arrayOf(13, 14, 0, 0),
        arrayOf(13, 17, 0, 0),
        arrayOf(13, 17, 0, 0)
    ),

    JEFF(
        arrayOf(11, 13, 0, 0),
        arrayOf(11, 13, 0, 0),
        arrayOf(11, 16, 0, 0),
        arrayOf(15, 16, 0, 0)
    ),

    SARAH(
        arrayOf(11, 11, 0, 1),
        arrayOf(11, 11, 0, 1),
        arrayOf(11, 11, 0, 1),
        arrayOf(11, 11, 0, 1),
    );





//    fun furniture(): GameObject? {
//        return Objects.stream().id(*allObjects)
//            .reachable()
//            .nearest()
//            .firstOrNull()
//    }
}