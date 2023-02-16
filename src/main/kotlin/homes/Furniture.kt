package homes

import org.powbot.api.Tile
import org.powbot.api.rt4.Varpbits

enum class Furniture(
    val home: String,
    val id: Int,
    val varp: Int,
    val text: Array<String>,
    val location: Tile
) {

    JESS_CABINET_1(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),
    JESS_CABINET_2(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JESS_DRAWER_1(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JESS_DRAWER_2(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JESS_BED(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JESS_BATHTUB(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JESS_TABLE(
        "Jess",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_CUPBOARD(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_DRESSER(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_DRAWERS(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_HAT_STAND(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_TABLE_1(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_TABLE_2(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_GRANDFATHER_CLOCK(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NOELLA_MIRROR(
        "Noella",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_BED(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_DOUBLE_BED(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_DRAWERS_1(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_DRAWERS_2(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_HAT_STAND(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_MIRROR(
        "Ross",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    ROSS_RANGE(
    "Ross",
    -1,
    -1,
    arrayOf("Remove", "Build"),
    Tile(-1,-1,-1)
    ),

    LARRY_DRAWERS_1(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_DRAWERS_2(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_GRANDFATHER_CLOCK(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_HAT_STAND(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_TABLE_1(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_TABLE_2(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LARRY_RANGE(
        "Larry",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_BOOKSHELF(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_DOUBLE_BED(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_DRAWERS(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_GRANDFATHER_CLOCK(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_SMALL_TABLE(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_TABLE(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    NORMAN_RANGE(
        "Norman",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    TAU_CUPBOARD(
        "Tau",
        40086,
        10557,
        arrayOf("Remove", "Build"),
        Tile(3045 , 3345, 0)
    ),

    TAU_HAT_STAND(
        "Tau",
        40295,
        10560,
        arrayOf("Remove", "Build"),
        Tile(3046, 3342, 0)
    ),

    TAU_SHELVES_1(
        "Tau",
        40087,
        10558,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    TAU_SHELVES_2(
        "Tau",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(3047,3342, 0)
    ),

    TAU_SINK(
        "Tau",
        40083,
        10554,
        arrayOf("Repair"),
        Tile(-1,-1,-1)
    ),

    TAU_TABLE_1(
        "Tau",
        40084,
        10555,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    TAU_TABLE_2(
        "Tau",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_BED(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_CHAIR_1(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_2(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_DRAWERS(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_TABLE(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_RANGE(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BARBARA_GRANDFATHER_CLOCK(
        "Barbara",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_CUPBOARD(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_SMALL_TABLE_1(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_SMALL_TABLE_2(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_DOUBLE_BED(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_MIRROR(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_TABLE(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    LEELA_SINK(
        "Leela",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_BED(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_CUPBOARD(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_HAT_STAND(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_SHELVES(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_SINK(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_SMALL_TABLE_1(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_SMALL_TABLE_2(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    MARIAH_TABLE(
        "Mariah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BOB_LARGE_TABLE(
        "Bob",
        39981,
        10554,
        arrayOf("Remove", "Build"),
        Tile(3238, 3488, 0)
    ),

    BOB_BOOKCASE_1(
        "Bob",
        39986,
        10559,
        arrayOf("Remove", "Build"),
        Tile(3236, 3489, 0)
    ),

    BOB_BOOKCASE_2(
        "Bob",
        39985,
        10558,
        arrayOf("Remove", "Build"),
        Tile(3236, 3484, 0)
    ),

    BOB_CABINET_1(
        "Bob",
        -1,
        10557,
        arrayOf("Remove", "Build"),
        Tile(3236, 3487, 0)
    ),

    BOB_CABINET_2(
        "Bob",
        -1,
        10556,
        arrayOf("Remove", "Build"),
        Tile(3236, 3486, 0)
    ),

    BOB_GRANDFATHER_CLOCK(
        "Bob",
        39982,
        10555,
        arrayOf("Repair"),
        Tile(3236, 3483, 0)
    ),

    BOB_WARDROBE(
        "Bob",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    BOB_DRAWERS(
        "Bob",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),


    JEFF_BOOKCASE(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_CHAIR(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_DRAWERS(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_DRESSER(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_TABLE(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_SHELVES(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_MIRROR(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    JEFF_BED(
        "Jeff",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_BED(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_DRESSER(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_SHELVES(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_SMALL_TABLE(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_TABLE(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    ),

    SARAH_RANGE(
        "Sarah",
        -1,
        -1,
        arrayOf("Remove", "Build"),
        Tile(-1,-1,-1)
    );

    companion object {
        fun get(home: String, varp: Int): Furniture? = Furniture.values().filter { it.name == home }.firstOrNull { it.varp == varp }
        fun get(home: String): Furniture? = Furniture.values().firstOrNull { it.name.equals(home, true) }
        fun isDone(home: String): Boolean = listOf(1, 3, 4).contains(get(home)?.varp?.let { Varpbits.value(it, false) })

//        fun isDone(Home: String, varp: Int):Boolean =

    }
}