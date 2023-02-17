package homes

import Constants
import Constants.BarbaraAllFurniture
import Constants.BobAllFurniture
import Constants.FURNITURE_VARPS
import Constants.JeffAllFurniture
import Constants.JessAllFurniture
import Constants.LarryAllFurniture
import Constants.LeelaAllFurniture
import Constants.MariahAllFurniture
import Constants.NoellaAllFurniture
import Constants.NormanAllFurniture
import Constants.RossAllFurniture
import Constants.SarahAllFurniture
import Constants.TauAllFurniture
import org.powbot.api.Tile
import org.powbot.api.rt4.Varpbits


enum class Homes(
    val home: String,
    val locations: Array<Tile>,
    val requiredItems: RequiredItems,
    val objects: IntArray,
    val stairs: IntArray
) {
    JESS(
        "Jess",
        arrayOf(Tile(2621, 3293, 1), Tile(2622, 3291, 1), Tile(2622, 3294, 1), Tile(2616, 3294, 1)),
        RequiredItems.JESS,
        JessAllFurniture,
        intArrayOf(-1)
    ),

    NOELLA(
        "Noella",
        arrayOf(Tile(2659, 3321, 0), Tile(2665, 3321, 1), Tile(2655, 3321, 1)),
        RequiredItems.NOELLA,
        NoellaAllFurniture,
        intArrayOf(-1)
    ),

    ROSS(
        "Ross",
        arrayOf(Tile(2614, 3317, 0), Tile(2617, 3316, 1), Tile(2614, 3315, 1), Tile(2616, 3317, 1)),
        RequiredItems.ROSS,
        RossAllFurniture,
        intArrayOf(-1)
    ),

    LARRY(
        "Larry",
        arrayOf(Tile(3037, 3363, 0), Tile(3035, 3364, 1)),
        RequiredItems.LARRY,
        LarryAllFurniture,
        intArrayOf(-1)
    ),

    NORMAN(
        "Norman",
        arrayOf(Tile(3037, 3345, 1), Tile(3038, 3344, 1), Tile(3035, 3345, 1)),
        RequiredItems.NORMAN,
        NormanAllFurniture,
        intArrayOf(-1)
    ),

    TAU(
        "Tau",
        arrayOf(Tile(3046, 3346, 0)),
        RequiredItems.TAU,
        TauAllFurniture,

        intArrayOf(-1)
    ),

    BARBARA(
        "Barbara",
        arrayOf(Tile(1749, 3534, 0), Tile(1748, 3537, 1)),
        RequiredItems.BARBARA,
        BarbaraAllFurniture,
        intArrayOf(-1)
    ),

    LEELA(
        "Leela",
        arrayOf(Tile(1785, 3593, 0), Tile(1787, 3592, 1)),
        RequiredItems.LEELA,
        LeelaAllFurniture,
        intArrayOf(-1)
    ),

    MARIAH(
        "Mariah",
        arrayOf(Tile(1765, 3621, 0), Tile(1766, 3620, 1)),
        RequiredItems.MARIAH,
        MariahAllFurniture,
        intArrayOf(-1)
    ),

    BOB(
        "Bob",
        arrayOf(Tile(3239, 3486, 0), Tile(-1,-1,-1)),
        RequiredItems.BOB,
        BobAllFurniture,
        intArrayOf(-1)
    ),

    JEFF(
        "Jeff",
        arrayOf(Tile(3240, 3451, 0), Tile(3238,3449,1), Tile(3239, 3447, 1)),
        RequiredItems.JEFF,
        JeffAllFurniture,
        intArrayOf(-1)
    ),

    SARAH(
        "Sarah",
        arrayOf(Tile(3234, 3384, 0)),
        RequiredItems.SARAH,
        SarahAllFurniture,
        intArrayOf(-1)
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







//    fun furniture(): GameObject? {
//        return Objects.stream().id(*allObjects)
//            .reachable()
//            .nearest()
//            .firstOrNull()
//    }
}