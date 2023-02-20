import org.powbot.api.Tile
import java.util.regex.Pattern


object Constants {
    val CONTRACT_PATTERN: Pattern = Pattern.compile("Amy\\|(Please could you g|G)o see (\\w*)[ ,][\\w\\s,-]*[?.] You can get another job once you have furnished \\w* home\\.")
//    val CONTRACT_FINISHED: Pattern = Pattern.compile("You have completed [\\d,]* contracts with a total of [\\d,]* points?\\.")
    val CONTRACT_FINISHED: Pattern = Pattern.compile("Aaah, nothing like a nice cuppa tea!")

    const val SELECT_CONTRACT_WIDGET = 219
    const val SELECT_CONTRACT_COMPONENT = 1

    const val BUILD_FURNITURE_WIDGET = 458
    const val BUILD_FURNITURE_COMPONENT = 3

    val NEW_CONTRACT_TILE = Tile(2990, 3365, 0)

    const val STEEL_BAR = 2353
    const val PLANK = 960
    const val OAK_PLANK = 8778
    const val TEAK_PLANK = 8780
    const val MAHOGANY_PLANK = 8782

    const val PORTAL = 28822

    val FURNITURE_VARPS = intArrayOf(10554, 10555, 10556, 10557, 10558, 10559, 10560, 10561)

    /*
    JESS
     */

    private const val JESS_DRAWERS_REMOVE = 40187
    private const val JESS_DRAWERS_BUILD = 40082

    private const val JESS_CABINET_1_REMOVE = 39899
    private const val JESS_CABINET_2_REMOVE = 39905
    private const val JESS_CABINET_BUILD = 40073

    private const val JESS_BED_REMOVE = 40193
    private const val JESS_BED_BUILD = 40080

    private const val JESS_TABLE_REMOVE = 400108
    private const val JESS_TABLE_BUILD = 40070

    private const val JESS_GRANDFATHER_CLOCK_REPAIR = 40141
    private const val JESS_BROKEN_BATH_REPAIR = 40212

    val JessUpstairs = intArrayOf(
        JESS_DRAWERS_REMOVE,
        JESS_DRAWERS_BUILD,
        JESS_CABINET_1_REMOVE,
        JESS_CABINET_2_REMOVE,
        JESS_CABINET_BUILD,
        JESS_BED_REMOVE,
        JESS_BED_BUILD,
        JESS_TABLE_REMOVE,
        JESS_TABLE_BUILD,
        JESS_GRANDFATHER_CLOCK_REPAIR,
        JESS_BROKEN_BATH_REPAIR
    )

    /*
    NOELLA
     */

    private const val NOELLA_DRESSER_REMOVE = 39948
    private const val NOELLA_DRESSER_BUILD = 40076

    private const val NOELLA_CUPBOARD_REMOVE = 40115
    private const val NOELLA_CUPBOARD_BUILD = 40078

    private const val NOELLA_HAT_STAND_REPAIR = 40139

    private const val NOELLA_BROKEN_MIRROR = 40179

    private const val NOELLA_DRAWERS_REMOVE = 40181
    private const val NOELLA_DRAWERS_BUILD = 40082

    private const val NOELLA_TABLE_REMOVE = 40108
    private const val NOELLA_TABLE_BUILD = 40070

    private const val NOELLA_GRANDFATHER_CLOCK_REPAIR = 40141

    val NoellaUpstairsRight = intArrayOf(
        NOELLA_DRESSER_REMOVE,
        NOELLA_DRESSER_BUILD,
        NOELLA_CUPBOARD_REMOVE,
        NOELLA_CUPBOARD_BUILD,
        NOELLA_HAT_STAND_REPAIR,
        NOELLA_BROKEN_MIRROR
    )

    val NoellaUpstairsLeft = intArrayOf(
        NOELLA_DRAWERS_REMOVE,
        NOELLA_DRAWERS_BUILD,
        NOELLA_TABLE_REMOVE,
        NOELLA_TABLE_BUILD,
        NOELLA_GRANDFATHER_CLOCK_REPAIR
    )

    val NoellaAllFurniture = intArrayOf(
        NOELLA_DRESSER_REMOVE,
        NOELLA_DRESSER_BUILD,
        NOELLA_CUPBOARD_REMOVE,
        NOELLA_CUPBOARD_BUILD,
        NOELLA_HAT_STAND_REPAIR,
        NOELLA_BROKEN_MIRROR,
        NOELLA_DRAWERS_REMOVE,
        NOELLA_DRAWERS_BUILD,
        NOELLA_TABLE_REMOVE,
        NOELLA_TABLE_BUILD,
        NOELLA_GRANDFATHER_CLOCK_REPAIR
    )

    /*
    ROSS
     */

    private const val ROSS_BROKEN_RANGE_REPAIR = 40148

    private const val ROSS_DRAWERS_REMOVE = 40187
    private const val ROSS_DRAWERS_BUILD = 40082

    private const val ROSS_LARGE_BED_REMOVE = 40200
    private const val ROSS_LARGE_BED_BUILD = 40080

    private const val ROSS_BED_REMOVE = 40207
    private const val ROSS_BED_BUILD = 40081

    private const val ROSS_HAT_STAND_REPAIR = 40139

    private const val ROSS_BROKEN_MIRROR_REPAIR = 40179

    val RossDownstairs = intArrayOf(
        ROSS_BROKEN_RANGE_REPAIR,
        ROSS_DRAWERS_REMOVE,
        ROSS_DRAWERS_BUILD
    )

    val RossUpstairs = intArrayOf(
        ROSS_LARGE_BED_REMOVE,
        ROSS_LARGE_BED_BUILD,
        ROSS_BED_REMOVE,
        ROSS_BED_BUILD,
        ROSS_HAT_STAND_REPAIR,
        ROSS_BROKEN_MIRROR_REPAIR
    )

    val RossAllFurniture = intArrayOf(
        ROSS_BROKEN_RANGE_REPAIR,
        ROSS_DRAWERS_REMOVE,
        ROSS_DRAWERS_BUILD,
        ROSS_LARGE_BED_REMOVE,
        ROSS_LARGE_BED_BUILD,
        ROSS_BED_REMOVE,
        ROSS_BED_BUILD,
        ROSS_HAT_STAND_REPAIR,
        ROSS_BROKEN_MIRROR_REPAIR
    )

    /*
    LARRY
     */

    private const val LARRY_DRAWERS_REMOVE = 40151
    private const val LARRY_DRAWERS_BUILD = 40082

    private const val LARRY_TABLE_REMOVE = 40102
    private const val LARRY_TABLE_BUILD = 40070

    private const val LARRY_GRANDFATHER_CLOCK_REPAIR = 40141

    private const val LARRY_BROKEN_RANGE_REPAIR = 40148

    private const val LARRY_HAT_STAND_REPAIR = 40139

    val LarryDownstairs = intArrayOf(
        LARRY_DRAWERS_REMOVE,
        LARRY_DRAWERS_BUILD,
        LARRY_TABLE_REMOVE,
        LARRY_TABLE_BUILD,
        LARRY_BROKEN_RANGE_REPAIR,
        LARRY_HAT_STAND_REPAIR
    )

    val LarryUpstairs = intArrayOf(
        LARRY_TABLE_REMOVE,
        LARRY_TABLE_BUILD,
        LARRY_GRANDFATHER_CLOCK_REPAIR
    )

    val LarryAllFurniture = intArrayOf(
        LARRY_DRAWERS_REMOVE,
        LARRY_DRAWERS_BUILD,
        LARRY_TABLE_REMOVE,
        LARRY_TABLE_BUILD,
        LARRY_GRANDFATHER_CLOCK_REPAIR,
        LARRY_BROKEN_RANGE_REPAIR,
        LARRY_HAT_STAND_REPAIR
    )

    /*
    NORMAN
     */
    private const val NORMAN_GRANDFATHER_CLOCK_REPAIR = 40141

    private const val NORMAN_TABLE_REMOVE = 40102
    private const val NORMAN_TABLE_BUILD = 40070

    private const val NORMAN_TABLE_2_REMOVE = 39967
    private const val NORMAN_TABLE_2_BUILD = 40069

    private const val NORMAN_BED_REMOVE = 40128
    private const val NORMAN_BED_BUILD = 40080

    private const val NORMAN_BOOKSHELF_REMOVE = 40134
    private const val NORMAN_BOOKSHELF_BUILD = 40074

    private const val NORMAN_DRAWERS_REMOVE = 40143
    private const val NORMAN_DRAWERS_BUILD = 40082

    private const val NORMAN_BROKEN_RANGE_REPAIR = 40148

    val NormanDownstairs = intArrayOf(
        NORMAN_GRANDFATHER_CLOCK_REPAIR,
        NORMAN_TABLE_REMOVE,
        NORMAN_TABLE_BUILD
    )

    val NormanUpstairs = intArrayOf(
        NORMAN_TABLE_2_REMOVE,
        NORMAN_TABLE_2_BUILD,
        NORMAN_BED_REMOVE,
        NORMAN_BED_BUILD,
        NORMAN_BOOKSHELF_REMOVE,
        NORMAN_BOOKSHELF_BUILD,
        NORMAN_DRAWERS_REMOVE,
        NORMAN_DRAWERS_BUILD,
        NORMAN_BROKEN_RANGE_REPAIR
    )

    val NormanAllFurniture = intArrayOf(
        NORMAN_GRANDFATHER_CLOCK_REPAIR,
        NORMAN_TABLE_REMOVE,
        NORMAN_TABLE_BUILD,
        NORMAN_TABLE_2_REMOVE,
        NORMAN_TABLE_2_BUILD,
        NORMAN_BED_REMOVE,
        NORMAN_BED_BUILD,
        NORMAN_BOOKSHELF_REMOVE,
        NORMAN_BOOKSHELF_BUILD,
        NORMAN_DRAWERS_REMOVE,
        NORMAN_DRAWERS_BUILD,
        NORMAN_BROKEN_RANGE_REPAIR
    )

    /*
    TAU
     */

    private const val TAU_BROKEN_SINK_REPAIR = 40100

    private const val TAU_TABLE_1_REMOVE = 40102
    private const val TAU_TABLE_2_REMOVE = 40108
    private const val TAU_TABLE_BUILD = 40070

    private const val TAU_CUPBOARD_REMOVE = 40115
    private const val TAU_CUPBOARD_BUILD = 40078

    private const val TAU_SHELVES_REMOVE = 40121
    private const val TAU_SHELVES_BUILD = 40077

    private const val TAU_HAT_STAND_REPAIR = 40139

    val TauDownstairs = intArrayOf(
        TAU_BROKEN_SINK_REPAIR,
        TAU_TABLE_1_REMOVE,
        TAU_TABLE_2_REMOVE,
        TAU_TABLE_BUILD,
        TAU_CUPBOARD_REMOVE,
        TAU_CUPBOARD_BUILD,
        TAU_SHELVES_REMOVE,
        TAU_SHELVES_BUILD,
        TAU_HAT_STAND_REPAIR
    )

    /*
    BARBARA
     */

    private const val BARBARA_GRANDFATHER_CLOCK_REPAIR = 39897

    private const val BARBARA_TABLE_REMOVE = 40017
    private const val BARBARA_TABLE_BUILD = 40072

    private const val BARBARA_BED_REMOVE = 40043
    private const val BARBARA_BED_BUILD = 40081

    private const val BARBARA_CHAIR_REMOVE = 40062
    private const val BARBARA_CHAIR_BUILD = 40079

    private const val BARBARA_DRAWERS_REMOVE = 40056
    private const val BARBARA_DRAWERS_BUILD = 40082

    private const val BARBARA_BROKEN_RANGE_REPAIR = 40067

    val BarbaraDownstairs = intArrayOf(
        BARBARA_GRANDFATHER_CLOCK_REPAIR,
        BARBARA_TABLE_REMOVE,
        BARBARA_TABLE_BUILD,
        BARBARA_BED_REMOVE,
        BARBARA_BED_BUILD,
        BARBARA_CHAIR_REMOVE,
        BARBARA_CHAIR_BUILD,
        BARBARA_DRAWERS_REMOVE,
        BARBARA_DRAWERS_BUILD,
        BARBARA_BROKEN_RANGE_REPAIR
    )

    /*
    LEELA
     */
    private const val LEELA_TABLE_1_REMOVE = 40017
    private const val LEELA_TABLE_1_BUILD = 40069
    private const val LEELA_TABLE_2_REMOVE = 40031
    private const val LEELA_TABLE_2_BUILD = 40072

    private const val LEELA_BROKEN_MIRROR_REPAIR = 40179

    private const val LEELA_BROKEN_SINK_REPAIR = 40022

    private const val LEELA_BED_REMOVE = 40050
    private const val LEELA_BED_BUILD = 40080

    private const val LEELA_CUPBOARD_REMOVE = 40115
    private const val LEELA_CUPBOARD_BUILD = 40078

    val LeelaDownstairs = intArrayOf(
        LEELA_TABLE_1_REMOVE,
        LEELA_TABLE_1_BUILD,
        LEELA_TABLE_2_REMOVE,
        LEELA_TABLE_2_BUILD,
        LEELA_BROKEN_SINK_REPAIR,
        LEELA_BED_REMOVE,
        LEELA_BED_BUILD
    )

    val LeelaUpstairs = intArrayOf(
        LEELA_BROKEN_MIRROR_REPAIR,
        LEELA_CUPBOARD_REMOVE,
        LEELA_CUPBOARD_BUILD
    )

    val LeelaAllFurniture = intArrayOf(
        LEELA_TABLE_1_REMOVE,
        LEELA_TABLE_1_BUILD,
        LEELA_TABLE_2_REMOVE,
        LEELA_TABLE_2_BUILD,
        LEELA_BROKEN_MIRROR_REPAIR,
        LEELA_BROKEN_SINK_REPAIR,
        LEELA_BED_REMOVE,
        LEELA_BED_BUILD,
        LEELA_CUPBOARD_REMOVE,
        LEELA_CUPBOARD_BUILD
    )

    /*
    MARIAH
     */

    private const val MARIAH_TABLE_1_REMOVE = 40017
    private const val MARIAH_TABLE_1_BUILD = 40069
    private const val MARIAH_TABLE_2_REMOVE = 40031
    private const val MARIAH_TABLE_2_BUILD = 40072

    private const val MARIAH_SHELVES_REMOVE = 40025
    private const val MARIAH_SHELVES_BUILD = 40077

    private const val MARIAH_BED_REMOVE = 40043
    private const val MARIAH_BED_BUILD = 40081

    private const val MARIAH_BROKEN_SINK_REPAIR = 40022

    private const val MARIAH_CUPBOARD_REMOVE = 40037
    private const val MARIAH_CUPBOARD_BUILD = 40078

    private const val MARIAH_HAT_STAND_REPAIR = 40139

    val MariahDownstairs = intArrayOf(
        MARIAH_TABLE_1_REMOVE,
        MARIAH_TABLE_1_BUILD,
        MARIAH_SHELVES_REMOVE,
        MARIAH_SHELVES_BUILD,
        MARIAH_BROKEN_SINK_REPAIR,
        MARIAH_CUPBOARD_REMOVE,
        MARIAH_CUPBOARD_BUILD,
        MARIAH_HAT_STAND_REPAIR
    )

    val MariahUpstairs = intArrayOf(
        MARIAH_TABLE_2_BUILD,
        MARIAH_TABLE_2_REMOVE,
        MARIAH_BED_REMOVE,
        MARIAH_BED_BUILD
    )

    val MariahAllFurniture = intArrayOf(
        MARIAH_TABLE_1_REMOVE,
        MARIAH_TABLE_1_BUILD,
        MARIAH_TABLE_2_REMOVE,
        MARIAH_TABLE_2_BUILD,
        MARIAH_SHELVES_REMOVE,
        MARIAH_SHELVES_BUILD,
        MARIAH_BED_REMOVE,
        MARIAH_BED_BUILD,
        MARIAH_BROKEN_SINK_REPAIR,
        MARIAH_CUPBOARD_REMOVE,
        MARIAH_CUPBOARD_BUILD,
        MARIAH_HAT_STAND_REPAIR
    )

    /*
    BOB
     */

    private const val BOB_LARGE_TABLE_REMOVE = 39892
    private const val BOB_LARGE_TABLE_BUILD = 40071

    private const val BOB_BROKEN_GRANDFATHER_CLOCK_REPAIR = 39897

    private const val BOB_CABINET_1_REMOVE = 39899
    private const val BOB_CABINET_2_REMOVE = 39905
    private const val BOB_CABINET_BUILD = 40073

    private const val BOB_BOOKCASE_REMOVE = 39911
    private const val BOB_BOOKCASE_BUILD = 40074

    private const val BOB_WARDROBE_REMOVE = 39917
    private const val BOB_WARDROBE_BUILD = 40075

    private const val BOB_DRAWERS_REMOVE = 39923
    private const val BOB_DRAWERS_BUILD = 40082

    val BobDownstairs = intArrayOf(
        BOB_LARGE_TABLE_REMOVE,
        BOB_LARGE_TABLE_BUILD,
        BOB_BROKEN_GRANDFATHER_CLOCK_REPAIR,
        BOB_CABINET_1_REMOVE,
        BOB_CABINET_2_REMOVE,
        BOB_CABINET_BUILD,
        BOB_BOOKCASE_REMOVE,
        BOB_BOOKCASE_BUILD
    )

    val BobUpstairs = intArrayOf(
        BOB_WARDROBE_REMOVE,
        BOB_WARDROBE_BUILD,
        BOB_DRAWERS_REMOVE,
        BOB_DRAWERS_BUILD
    )

    val BobAllFurniture = intArrayOf(
        BOB_LARGE_TABLE_REMOVE,
        BOB_LARGE_TABLE_BUILD,
        BOB_BROKEN_GRANDFATHER_CLOCK_REPAIR,
        BOB_CABINET_1_REMOVE,
        BOB_CABINET_2_REMOVE,
        BOB_CABINET_BUILD,
        BOB_BOOKCASE_REMOVE,
        BOB_BOOKCASE_BUILD,
        BOB_WARDROBE_REMOVE,
        BOB_WARDROBE_BUILD,
        BOB_DRAWERS_REMOVE,
        BOB_DRAWERS_BUILD
    )

    /*
    JEFF
     */

    private const val JEFF_TABLE_REMOVE = 39989
    private const val JEFF_TABLE_BUILD = 40070

    private const val JEFF_BOOKCASE_REMOVE = 39911
    private const val JEFF_BOOKCASE_BUILD = 40074

    private const val JEFF_SHELVES_REMOVE = 39935
    private const val JEFF_SHELVES_BUILD = 40077

    private const val JEFF_BED_REMOVE = 39942
    private const val JEFF_BED_BUILD = 40080

    private const val JEFF_DRAWERS_REMOVE = 39923
    private const val JEFF_DRAWERS_BUILD = 40082

    private const val JEFF_DRESSERS_REMOVE = 39948
    private const val JEFF_DRESSER_BUILD = 40076

    private const val JEFF_BROKEN_MIRROR_REPAIR = 39953

    private const val JEFF_CHAIR_REMOVE = 39955
    private const val JEFF_CHAIR_BUILD = 40079

    val JeffDownstairs = intArrayOf(
        JEFF_TABLE_REMOVE,
        JEFF_TABLE_BUILD,
        JEFF_BOOKCASE_REMOVE,
        JEFF_BOOKCASE_BUILD,
        JEFF_SHELVES_REMOVE,
        JEFF_SHELVES_BUILD
    )

    val JeffUpstairs = intArrayOf(
        JEFF_BED_REMOVE,
        JEFF_BED_BUILD,
        JEFF_DRAWERS_REMOVE,
        JEFF_DRAWERS_BUILD,
        JEFF_DRESSERS_REMOVE,
        JEFF_DRESSER_BUILD,
        JEFF_BROKEN_MIRROR_REPAIR,
        JEFF_CHAIR_REMOVE,
        JEFF_CHAIR_BUILD
    )

    val JeffAllFurniture = intArrayOf(
        JEFF_TABLE_REMOVE,
        JEFF_TABLE_BUILD,
        JEFF_BOOKCASE_REMOVE,
        JEFF_BOOKCASE_BUILD,
        JEFF_SHELVES_REMOVE,
        JEFF_SHELVES_BUILD,
        JEFF_BED_REMOVE,
        JEFF_BED_BUILD,
        JEFF_DRAWERS_REMOVE,
        JEFF_DRAWERS_BUILD,
        JEFF_DRESSERS_REMOVE,
        JEFF_DRESSER_BUILD,
        JEFF_BROKEN_MIRROR_REPAIR,
        JEFF_CHAIR_REMOVE,
        JEFF_CHAIR_BUILD
    )

    /*
    SARAH
     */

    private const val SARAH_TABLE_1_REMOVE = 39961
    private const val SARAH_TABLE_1_BUILD = 40069

    private const val SARAH_TABLE_2_REMOVE = 39967
    private const val SARAH_TABLE_2_BUILD = 40070

    private const val SARAH_BED_REMOVE = 39974
    private const val SARAH_BED_BUILD = 40081

    private const val SARAH_DRESSER_REMOVE = 39948
    private const val SARAH_DRESSER_BUILD = 40076

    private const val SARAH_SHELVES_REMOVE = 39935
    private const val SARAH_SHELVES_BUILD = 40077

    private const val SARAH_BROKEN_RANGE_REPAIR = 40148

    val SarahDownstairs = intArrayOf(
        SARAH_TABLE_1_REMOVE,
        SARAH_TABLE_1_BUILD,
        SARAH_TABLE_2_REMOVE,
        SARAH_TABLE_2_BUILD,
        SARAH_BED_REMOVE,
        SARAH_BED_BUILD,
        SARAH_DRESSER_REMOVE,
        SARAH_DRESSER_BUILD,
        SARAH_SHELVES_REMOVE,
        SARAH_SHELVES_BUILD,
        SARAH_BROKEN_RANGE_REPAIR
    )

}