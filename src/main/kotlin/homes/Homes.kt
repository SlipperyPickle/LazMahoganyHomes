package homes

import Constants.FURNITURE_VARPS
import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.TEAK_PLANK
import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Varpbits


enum class Homes(
    val home: String,
    val npcLocation: Tile,
    val startTile: Tile,
    val rooms: Array<Area>,
    val requiredItems: RequiredItems
) {
    JESS(
        "Jess",
        Tile(2621, 3293, 1),
        Tile(2622, 3291, 1),
        arrayOf(
            Area(Tile(2611, 3296, 1), Tile(2623, 3291, 1))
        ),
        RequiredItems.JESS
    ),

    NOELLA(
        "Noella",
        Tile(2655, 3321, 0),
        Tile(2665, 3321, 1),
        arrayOf(
            Area(Tile(2660, 3324, 1), Tile(2666, 3317, 1)),
            Area(Tile(2652, 3323, 1), Tile(2658, 3317, 1)),
            Area(Tile(2653, 3322, 0), Tile(2665, 3319, 0))
        ),
        RequiredItems.NOELLA
    ),

    ROSS(
        "Ross",
        Tile(2614, 3317, 0),
        Tile(2617, 3316, 1),
        arrayOf(
            Area(Tile(2610, 3319, 1), Tile(2618, 3314, 1)),
            Area(Tile(2611, 3318, 0), Tile(2617, 3315, 0)),
        ),
        RequiredItems.ROSS
    ),

    LARRY(
        "Larry",
        Tile(3037, 3363, 0),
        Tile(3035, 3364, 1),
        arrayOf(
            Area(Tile(3033, 3365, 1), Tile(3042, 3360, 1)),
            Area(Tile(3033, 3368, 0), Tile(3042, 3361, 0)),
        ),
        RequiredItems.LARRY
    ),

    NORMAN(
        "Norman",
        Tile(3035, 3345, 1),
        Tile(3037, 3346, 0),
        arrayOf(
            Area(Tile(3035, 3347, 1), Tile(3040, 3344, 1)),
            Area(Tile(3035, 3347, 0), Tile(3040, 3342, 0)),
        ),
        RequiredItems.NORMAN
    ),

    TAU(
        "Tau",
        Tile(3046, 3346, 0),
        Tile(3047, 3348, 0),
        arrayOf(
            Area(Tile(3043, 3350, 0), Tile(3052, 3340, 0)),
        ),
        RequiredItems.TAU
    ),

    BARBARA(
        "Barbara",
        Tile(1749, 3534, 0),
        Tile(1747, 3535, 0),
        arrayOf(
            Area(Tile(1747, 3536, 0), Tile(1754, 3532, 0)),
            Area(Tile(1747, 3539, 0), Tile(1749, 3537, 0)),
        ),
        RequiredItems.BARBARA
    ),

    LEELA(
        "Leela",
        Tile(1785, 3593, 0),
        Tile(1787, 3592, 1),
        arrayOf(
            Area(Tile(1781, 3595, 0), Tile(1789, 3589, 0)),
            Area(Tile(1781, 3595, 1), Tile(1789, 3589, 1)),
        ),
        RequiredItems.LEELA
    ),

    MARIAH(
        "Mariah",
        Tile(1765, 3621, 0),
        Tile(1766, 3620, 1),
        arrayOf(
            Area(Tile(1762, 3624, 1), Tile(1771, 3618, 1)),
            Area(Tile(1762, 3624, 0), Tile(1771, 3618, 0)),
        ),
        RequiredItems.MARIAH
    ),

    BOB(
        "Bob",
        Tile(3239, 3486, 0),
        Tile(3242, 3489, 1),
        arrayOf(
            Area(Tile(3235, 3490, 1), Tile(3242, 3483, 1)),
            Area(Tile(3235, 3490, 0), Tile(3241, 3483, 0)),
        ),
        RequiredItems.BOB
    ),

    JEFF(
        "Jeff",
        Tile(3240, 3451, 0),
        Tile(3239, 3447, 1),
        arrayOf(
            Area(Tile(3235, 3455, 1), Tile(3244, 3445, 1)),
            Area(Tile(3235, 3455, 0), Tile(3244, 3445, 0)),
        ),
        RequiredItems.JEFF
    ),

    SARAH(
        "Sarah",
        Tile(3234, 3384, 0),
        Tile(3235, 3386, 0),
        arrayOf(
            Area(Tile(3233, 3386, 0), Tile(3238, 3382, 0)),
        ),
        RequiredItems.SARAH
    );

    fun getRequiredItems(name: String?, tier: Int): Array<Int> {
        val home = Homes.values().firstOrNull { it.name.equals(name, true) }
        val result = when (tier) {
            0 -> home!!.requiredItems.beginner
            1 -> home!!.requiredItems.novice
            2 -> home!!.requiredItems.adept
            3 -> home!!.requiredItems.expert
            else -> arrayOf(-1, -1)
        }
        return result
    }

    fun getPlank(tier: Int): Int {
        val result = when (tier) {
            0 -> PLANK
            1 -> OAK_PLANK
            2 -> TEAK_PLANK
            3 -> MAHOGANY_PLANK
            else -> -1
        }
        return result
    }
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
            val home = Homes.values().firstOrNull { it.name.equals(name, true) }
            if (home != null) {
                for (room in home.rooms) {
                    if (room.contains(Players.local())) {
                        return true
                    }
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
}