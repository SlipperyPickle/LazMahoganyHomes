package homes

import Constants
import Constants.BarbaraDownstairs
import Constants.BobDownstairs
import Constants.BobUpstairs
import Constants.FURNITURE_VARPS
import Constants.JeffDownstairs
import Constants.JeffUpstairs
import Constants.JessUpstairs
import Constants.LarryDownstairs
import Constants.LarryUpstairs
import Constants.LeelaDownstairs
import Constants.LeelaUpstairs
import Constants.MariahDownstairs
import Constants.MariahUpstairs
import Constants.NoellaUpstairsLeft
import Constants.NoellaUpstairsRight
import Constants.NormanDownstairs
import Constants.NormanUpstairs
import Constants.RossDownstairs
import Constants.RossUpstairs
import Constants.SarahDownstairs
import Constants.TauDownstairs
import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Varpbits


enum class Homes(
    val home: String,
    val npcLocation: Tile,
    val rooms: Array<Rooms>,
    val requiredItems: RequiredItems
) {
    JESS(
        "Jess",
        Tile(2621, 3293, 1),
        arrayOf(Rooms.JESS_UPSTAIRS),
        RequiredItems.JESS
    ),

    NOELLA(
        "Noella",
        Tile(2659, 3321, 0),
        arrayOf(Rooms.NOELLA_UPSTAIRS_RIGHT, Rooms.NOELLA_UPSTAIRS_LEFT),
        RequiredItems.NOELLA
    ),

    ROSS(
        "Ross",
        Tile(2614, 3317, 0),
        arrayOf(Rooms.ROSS_UPSTAIRS, Rooms.ROSS_DOWNSTAIRS),
        RequiredItems.ROSS
    ),

    LARRY(
        "Larry",
        Tile(3037, 3363, 0),
        arrayOf(Rooms.LARRY_UPSTAIRS, Rooms.LARRY_DOWNSTAIRS),
        RequiredItems.LARRY
    ),

    NORMAN(
        "Norman",
        Tile(3037, 3345, 1),
        arrayOf(Rooms.NORMAN_UPSTAIRS, Rooms.NORMAN_DOWNSTAIRS),
        RequiredItems.NORMAN
    ),

    TAU(
        "Tau",
        Tile(3046, 3346, 0),
        arrayOf(Rooms.TAU_DOWNSTAIRS),
        RequiredItems.TAU
    ),

    BARBARA(
        "Barbara",
        Tile(1749, 3534, 0),
        arrayOf(Rooms.BARBARA_DOWNSTAIRS),
        RequiredItems.BARBARA
    ),

    LEELA(
        "Leela",
        Tile(1785, 3593, 0),
        arrayOf(Rooms.LEELA_UPSTAIRS, Rooms.LEELA_DOWNSTAIRS),
        RequiredItems.LEELA
    ),

    MARIAH(
        "Mariah",
        Tile(1765, 3621, 0),
        arrayOf(Rooms.MARIAH_UPSTAIRS, Rooms.MARIAH_DOWNSTAIRS),
        RequiredItems.MARIAH
    ),

    BOB(
        "Bob",
        Tile(3239, 3486, 0),
        arrayOf(Rooms.BOB_UPSTAIRS, Rooms.BOB_DOWNSTAIRS),
        RequiredItems.BOB
    ),

    JEFF(
        "Jeff",
        Tile(3240, 3451, 0),
        arrayOf(Rooms.JEFF_UPSTAIRS, Rooms.JEFF_DOWNSTAIRS),
        RequiredItems.JEFF
    ),

    SARAH(
        "Sarah",
        Tile(3234, 3384, 0),
        arrayOf(Rooms.SARAH_DOWNSTAIRS),
        RequiredItems.SARAH
    );

    companion object {
        fun get(name: String): Homes? = Homes.values().firstOrNull { it.name.equals(name, true) }

        fun furnitureLeft(): Int {
            var count = 0
            for (varp in FURNITURE_VARPS) {
                val i = Varpbits.value(varp, false)
                if (listOf(1, 3, 4).contains(i)) {
                    count++
                }
            }
            return count
        }

        fun inCurrentHome(name: String): Boolean {
            //TODO
            val home = Homes.values().firstOrNull { it.name.equals(name, true) }
            if (home != null) {
                for (room in home.rooms) {
                    return room.area.contains(Players.local())
                }
            }
            return false
        }
    }
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
}

enum class Rooms (
    val home: String,
    val area: Area,
    val objects: IntArray
) {
    JESS_UPSTAIRS(
        "Jess",
        Area(Tile(2610, 3297, 1), Tile(2624, 3290, 1)),
        JessUpstairs
    ),

    NOELLA_UPSTAIRS_RIGHT(
        "Noella",
        Area(Tile(2660, 3324, 1), Tile(2666, 3317, 1)),
        NoellaUpstairsRight
    ),

    NOELLA_UPSTAIRS_LEFT(
        "Noella",
        Area(Tile(2652, 3323, 1), Tile(2658, 3317, 1)),
        NoellaUpstairsLeft
    ),

    ROSS_UPSTAIRS(
        "Ross",
        Area(Tile(2609, 3328, 1), Tile(2619, 3321, 1)),
        RossUpstairs
    ),

    ROSS_DOWNSTAIRS(
        "Ross",
        Area(Tile(2610, 3327, 0), Tile(2618, 3322, 0)),
        RossDownstairs
    ),

    LARRY_UPSTAIRS(
        "Larry",
        Area(Tile(3033, 3365, 1), Tile(3042, 3360, 1)),
        LarryUpstairs
    ),

    LARRY_DOWNSTAIRS(
        "Larry",
        Area(Tile(3033, 3368, 0), Tile(3042, 3361, 0)),
        LarryDownstairs
    ),

    NORMAN_DOWNSTAIRS(
        "Norman",
        Area(Tile(3034, 3347, 0), Tile(3041, 3341, 0)),
        NormanDownstairs
    ),

    NORMAN_UPSTAIRS(
        "Norman",
        Area(Tile(3034, 3348, 1), Tile(3041, 3343, 1)),
        NormanUpstairs
    ),

    TAU_DOWNSTAIRS(
        "Tau",
        Area(Tile(3043, 3350, 0), Tile(3052, 3340, 0)),
        TauDownstairs
    ),

    BARBARA_DOWNSTAIRS(
        "Barbara",
        Area(Tile(1746, 3540, 0), Tile(1755, 3531, 0)),
        BarbaraDownstairs
    ),

    LEELA_UPSTAIRS(
        "Leela",
        Area(Tile(1781, 3595, 1), Tile(1789, 3589, 1)),
        LeelaUpstairs
    ),

    LEELA_DOWNSTAIRS(
        "Leela",
        Area(Tile(1781, 3595, 0), Tile(1789, 3589, 0)),
        LeelaDownstairs
    ),

    MARIAH_UPSTAIRS(
        "Mariah",
        Area(Tile(1762, 3624, 1), Tile(1771, 3618, 1)),
        MariahUpstairs
    ),

    MARIAH_DOWNSTAIRS(
        "Mariah",
        Area(Tile(1762, 3624, 0), Tile(1771, 3618, 0)),
        MariahDownstairs
    ),

    BOB_UPSTAIRS(
        "Bob",
        Area(Tile(3234, 3491, 1), Tile(3243, 3482, 1)),
        BobUpstairs
    ),

    BOB_DOWNSTAIRS(
        "Bob",
        Area(Tile(3234, 3491, 0), Tile(3242, 3482, 0)),
        BobDownstairs
    ),

    JEFF_UPSTAIRS(
        "Jeff",
        Area(Tile(3235, 3455, 1), Tile(3244, 3445, 1)),
        JeffUpstairs
    ),

    JEFF_DOWNSTAIRS(
        "Jeff",
        Area(Tile(3235, 3455, 0), Tile(3244, 3445, 0)),
        JeffDownstairs
    ),

    SARAH_DOWNSTAIRS(
        "Sarah",
        Area(Tile(3233, 3386, 0), Tile(3238, 3382, 0)),
        SarahDownstairs
    )
}
