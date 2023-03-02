package homes

import homes.Barbara.AllBarbara
import homes.Bob.AllBob
import homes.Jeff.AllJeff
import homes.Jess.AllJess
import homes.Larry.AllLarry
import homes.Leela.AllLeela
import homes.Mariah.AllMariah
import homes.Noella.AllNoella
import homes.Norman.AllNorman
import homes.Ross.AllRoss
import homes.Sarah.AllSarah
import homes.Tau.AllTau
import org.powbot.api.Tile

class Furniture(val id: Int, val action: String, val tile: Tile) {
    companion object {
        fun getFurniture(home: Homes): List<Furniture> {
            return when (home) {
                Homes.BARBARA -> AllBarbara
                Homes.BOB -> AllBob
                Homes.JEFF -> AllJeff
                Homes.JESS -> AllJess
                Homes.LARRY -> AllLarry
                Homes.LEELA -> AllLeela
                Homes.MARIAH -> AllMariah
                Homes.NOELLA -> AllNoella
                Homes.NORMAN -> AllNorman
                Homes.ROSS -> AllRoss
                Homes.SARAH -> AllSarah
                Homes.TAU -> AllTau
            }
        }
    }
}

object Barbara {
    private val DrawersRemove = Furniture(40056, "Remove", Tile(x=1754, y=3535, floor=0))
    private val DrawersBuild = Furniture(40082, "Build", Tile(x=1754, y=3535, floor=0))
    private val TableRemove = Furniture(40017, "Remove", Tile(x=1751, y=3535, floor=0))
    private val TableBuild = Furniture(40072, "Build", Tile(x=1751, y=3535, floor=0))
    private val ChairOneRemove = Furniture(40062, "Remove", Tile(x=1751, y=3534, floor=0))
    private val ChairOneBuild = Furniture(40079, "Build", Tile(x=1751, y=3534, floor=0))
    private val ChairTwoRemove = Furniture(40062, "Remove", Tile(x=1750, y=3532, floor=0))
    private val ChairTwoBuild = Furniture(40079, "Build", Tile(x=1750, y=3532, floor=0))
    private val RangeRepair = Furniture(40067, "Repair", Tile(x=1748, y=3532, floor=0))
    private val GrandFatherClockRepair = Furniture(39897, "Repair", Tile(x=1749, y=3536, floor=0))
    private val Door = Furniture(7452, "Open", Tile(x=1748, y=3537, floor=0))
    private val BedRemove = Furniture(40043, "Remove", Tile(x=1749, y=3539, floor=0))
    private val BedBuild = Furniture(40081, "Build", Tile(x=1749, y=3539, floor=0))

    val AllBarbara = listOf(
        DrawersRemove, DrawersBuild, TableRemove, TableBuild, ChairOneRemove,
        ChairOneBuild, ChairTwoRemove, ChairTwoBuild, RangeRepair, GrandFatherClockRepair, Door, BedRemove, BedBuild
    )
}

object Bob {
    private val WardrobeRemove = Furniture(39917, "Remove", Tile(x=3242, y=3487, floor=1))
    private val WardrobeBuild = Furniture(40075, "Build", Tile(x=3242, y=3487, floor=1))
    private val DrawersRemove = Furniture(39923, "Remove", Tile(x=3242, y=3486, floor=1))
    private val DrawersBuild = Furniture(40082, "Build", Tile(x=3242, y=3486, floor=1))
    private val Staircase = Furniture(11799, "Climb-down", Tile(x=3241, y=3490, floor=1))
    private val BookcaseOneRemove = Furniture(39911, "Remove", Tile(x=3235, y=3489, floor=0))
    private val BookcaseOneBuild = Furniture(40074, "Build", Tile(x=3235, y=3489, floor=0))
    private val CabinetOneRemove = Furniture(39905, "Remove", Tile(x=3235, y=3487, floor=0))
    private val CabinetOneBuild = Furniture(40073, "Build", Tile(x=3235, y=3487, floor=0))
    private val CabinetTwoRemove = Furniture(39899, "Remove", Tile(x=3235, y=3486, floor=0))
    private val CabinetTwoBuild = Furniture(40073, "Build", Tile(x=3235, y=3486, floor=0))
    private val TableRemove = Furniture(39892, "Remove", Tile(x=3238, y=3487, floor=0))
    private val TableBuild = Furniture(40071, "Build", Tile(x=3238, y=3487, floor=0))
    private val BookcaseTwoRemove = Furniture(39911, "Remove", Tile(x=3235, y=3484, floor=0))
    private val BookcaseTwoBuild = Furniture(40074, "Build", Tile(x=3235, y=3484, floor=0))
    private val GrandFatherClock = Furniture(39897, "Repair", Tile(x=3235, y=3483, floor=0))

    val AllBob = listOf(
        WardrobeRemove, WardrobeBuild, DrawersRemove, DrawersBuild, Staircase, BookcaseOneRemove, BookcaseOneBuild,
        CabinetOneRemove, CabinetOneBuild, CabinetTwoRemove, CabinetTwoBuild, TableRemove, TableBuild,
        BookcaseTwoRemove, BookcaseTwoBuild, GrandFatherClock
    )
}

object Jeff {
    private val Mirror = Furniture(39953, "Repair", Tile(x=3238, y=3454, floor=1))
    private val BedRemove = Furniture(39942, "Remove", Tile(x=3240, y=3454, floor=1))
    private val BedBuild = Furniture(40080, "Build", Tile(x=3240, y=3454, floor=1))
    private val DrawersRemove = Furniture(39923, "Remove", Tile(x=3242, y=3454, floor=1))
    private val DrawersBuild = Furniture(40082, "Build", Tile(x=3242, y=3454, floor=1))
    private val DresserRemove = Furniture(39948, "Remove", Tile(x=3242, y=3446, floor=1))
    private val DresserBuild = Furniture(40076, "Build", Tile(x=3242, y=3446, floor=1))
    private val ChairRemove = Furniture(39955, "Remove", Tile(x=3242, y=3447, floor=1))
    private val ChairBuild = Furniture(40079, "Build", Tile(x=3242, y=3447, floor=1))
    private val Staircase = Furniture(11793, "Climb-down", Tile(x=3238, y=3448, floor=1))
    private val ShelvesRemove = Furniture(39935, "Remove", Tile(x=3241, y=3447, floor=0))
    private val ShelvesBuild = Furniture(40077, "Build", Tile(x=3241, y=3447, floor=0))
    private val Door = Furniture(11775, "Open", Tile(x=3238, y=3450, floor=0))
    private val TableRemove = Furniture(39929, "Remove", Tile(x=3238, y=3453, floor=0))
    private val TableBuild = Furniture(40070, "Build", Tile(x=3238, y=3453, floor=0))
    private val BookcaseRemove = Furniture(39911, "Remove", Tile(x=3242, y=3454, floor=0))
    private val BookcaseBuild = Furniture(40074, "Build", Tile(x=3242, y=3454, floor=0))

    val AllJeff = listOf(
        Mirror, BedRemove, BedBuild, DrawersRemove, DrawersBuild, DresserRemove, DresserBuild, ChairRemove, ChairBuild,
        Staircase, ShelvesRemove, ShelvesBuild, Door, TableRemove, TableBuild, BookcaseRemove, BookcaseBuild
    )
}

object Jess {
    private val DrawersOneRemove = Furniture(40187, "Remove", Tile(x=2620, y=3291, floor=1))
    private val DrawersOneBuild = Furniture(40082, "Build", Tile(x=2620, y=3291, floor=1))
    private val DoorOne = Furniture(1540, "Open", Tile(2622, 3293, 1))
    private val CabinetOneRemove = Furniture(39905, "Remove", Tile(x=2622, y=3295, floor=1))
    private val CabinetOneBuild = Furniture(40073, "Build", Tile(x=2622, y=3295, floor=1))
    private val CabinetTwoRemove = Furniture(39899, "Remove", Tile(x=2621, y=3295, floor=1))
    private val CabinetTwoBuild = Furniture(40073, "Build", Tile(x=2621, y=3295, floor=1))
    private val DoorTwo = Furniture(1540, "Open", Tile(2617, 3294, 1))
    private val BedRemove = Furniture(40193, "Remove", Tile(x=2615, y=3296, floor=1))
    private val BedBuild = Furniture(40080, "Build", Tile(x=2615, y=3296, floor=1))
    private val DrawersTwoRemove = Furniture(40187, "Remove", Tile(x=2612, y=3296, floor=1))
    private val DrawersTwoBuild = Furniture(40082, "Build", Tile(x=2612, y=3296, floor=1))
    private val GrandFatherClock = Furniture(40141, "Repair", Tile(x=2612, y=3295, floor=1))
    private val TableRemove = Furniture(40108, "Remove", Tile(x=2612, y=3294, floor=1))
    private val TableBuild = Furniture(40070, "Build", Tile(x=2612, y=3294, floor=1))
    private val DoorThree = Furniture(1540, "Open", Tile(x=2615, y=3292, floor=1))
    private val Bath = Furniture(40212, "Repair", Tile(x=2616, y=3291, floor=1))

    val AllJess = listOf(
        DrawersOneRemove, DrawersOneBuild, DoorOne, CabinetOneRemove, CabinetOneBuild, CabinetTwoRemove,
        CabinetTwoBuild, DoorTwo, BedRemove, BedBuild, DrawersTwoRemove, DrawersTwoBuild, GrandFatherClock,
        TableRemove, TableBuild, DoorThree, Bath
    )
}

object Larry {
    private val GrandFatherClock = Furniture(40141, "Repair", Tile(x=3034, y=3364, floor=1))
    private val TableOneRemove = Furniture(40102, "Remove", Tile(x=3039, y=3363, floor=1))
    private val TableOneBuild = Furniture(40070, "Build", Tile(x=3039, y=3363, floor=1))
    private val Staircase = Furniture(24076, "Climb-down", Tile(x=3035, y=3363, floor=1))
    private val TableTwoRemove = Furniture(40102, "Remove", Tile(x=3038, y=3365, floor=0))
    private val TableTwoBuild = Furniture(40070, "Build", Tile(x=3038, y=3365, floor=0))
    private val HatStand = Furniture(40139, "Repair", Tile(x=3041, y=3362, floor=0))
    private val DrawersOneRemove = Furniture(40151, "Remove", Tile(x=3041, y=3364, floor=0))
    private val DrawersOneBuild = Furniture(40082, "Build", Tile(x=3041, y=3364, floor=0))
    private val DrawersTwoRemove = Furniture(40151, "Remove", Tile(x=3041, y=3365, floor=0))
    private val DrawersTwoBuild = Furniture(40082, "Build", Tile(x=3041, y=3365, floor=0))
    private val Range = Furniture(40148, "Repair", Tile(x=3040, y=3367, floor=0))

    val AllLarry = listOf(
        GrandFatherClock, TableOneRemove, TableOneBuild, Staircase, TableTwoRemove, TableTwoBuild, HatStand,
        DrawersOneRemove, DrawersOneBuild, DrawersTwoRemove, DrawersTwoBuild, Range
    )
}

object Leela {
    private val TableOneRemove = Furniture(40017, "Remove", Tile(x=1782, y=3591, floor=1))
    private val TableOneBuild = Furniture(40072, "Build", Tile(x=1782, y=3591, floor=1))

    private val BrokenMirror  = Furniture(40179, "Repair", Tile(x=1786, y=3590, floor=1))
    private val CupBoardRemove = Furniture(40115, "Remove", Tile(x=1788, y=3590, floor=1))
    private val CupBoardBuild = Furniture(40078, "Build", Tile(x=1788, y=3590, floor=1))
    private val Ladder = Furniture(11802, "Climb-down", Tile(x=1788, y=3592, floor=1))
    private val Sink = Furniture(40022, "Repair", Tile(x=1787, y=3594, floor=0))
    private val TableTwoRemove  = Furniture(40031, "Remove", Tile(x=1784, y=3594, floor=0))
    private val TableTwoBuild  = Furniture(40069, "Build", Tile(x=1784, y=3594, floor=0))
    private val TableThreeRemove  = Furniture(40031, "Remove", Tile(x=1782, y=3592, floor=0))
    private val TableThreeBuild  = Furniture(40069, "Build", Tile(x=1782, y=3592, floor=0))
    private val BedRemove  = Furniture(40050, "Remove", Tile(x=1783, y=3591, floor=0))
    private val BedBuild  = Furniture(40080, "Build", Tile(x=1783, y=3591, floor=0))

    val AllLeela = listOf(
        TableOneRemove, TableOneBuild, BrokenMirror, CupBoardRemove, CupBoardBuild, Ladder, Sink, TableTwoRemove,
        TableTwoBuild, TableThreeRemove, TableThreeBuild, BedRemove, BedBuild
    )
}

object Mariah {
    private val Door = Furniture(7452, "Open", Tile(x=1768, y=3622, floor=1))
    private val TableOneRemove = Furniture(40031, "Remove", Tile(x=1770, y=3623, floor=1))
    private val TableOneBuild = Furniture(40069, "Build", Tile(x=1770, y=3623, floor=1))
    private val TableTwoRemove = Furniture(40031, "Remove", Tile(x=1764, y=3620, floor=1))
    private val TableTwoBuild = Furniture(40069, "Build", Tile(x=1764, y=3620, floor=1))
    private val BedRemove = Furniture(40043, "Remove", Tile(x=1765, y=3622, floor=1))
    private val BedBuild = Furniture(40081, "Build", Tile(x=1765, y=3622, floor=1))
    private val Ladder = Furniture(11802, "Climb-down", Tile(x=1767, y=3620, floor=1))
    private val CookingShelvesRemove = Furniture(40025, "Remove", Tile(x=1766, y=3619, floor=0))
    private val CookingShelvesBuild = Furniture(40077, "Build", Tile(x=1766, y=3619, floor=0))
    private val CupBoardRemove = Furniture(40037, "Remove", Tile(x=1763, y=3620, floor=0))
    private val CupBoardBuild = Furniture(40078, "Build", Tile(x=1763, y=3620, floor=0))
    private val Sink = Furniture(40022, "Repair", Tile(x=1763, y=3622, floor=0))
    private val HatStand = Furniture(40139, "Repair", Tile(x=1764, y=3623, floor=0))
    private val TableThreeRemove = Furniture(40017, "Remove", Tile(x=1769, y=3622, floor=0))
    private val TableThreeBuild = Furniture(40072, "Build", Tile(x=1769, y=3622, floor=0))

    val AllMariah = listOf(
        Door, TableOneRemove, TableOneBuild, TableTwoRemove, TableTwoBuild, BedRemove, BedBuild, Ladder,
        CookingShelvesRemove, CookingShelvesBuild, CupBoardRemove, CupBoardBuild, Sink, HatStand, TableThreeRemove,
        TableThreeBuild
    )
}

object Noella {
    private val HatStand = Furniture(40139, "Repair", Tile(x=2665, y=3318, floor=1))
    private val Mirror = Furniture(40179, "Repair", Tile(x=2661, y=3318, floor=1))
    private val CupboardRemove = Furniture(40115, "Remove", Tile(x=2661, y=3321, floor=1))
    private val CupboardBuild = Furniture(40078, "Build", Tile(x=2661, y=3321, floor=1))
    private val DresserRemove = Furniture(39948, "Remove", Tile(x=2662, y=3323, floor=1))
    private val DresserBuild = Furniture(40076, "Build", Tile(x=2662, y=3323, floor=1))
    private val Staircase = Furniture(15648, "Climb-down", Tile(x=2664, y=3322, floor=1))
    private val LadderOne = Furniture(17026, "Climb-up", Tile(x=2655, y=3322, floor=0))
    private val TableOneRemove = Furniture(40108, "Remove", Tile(x=2657, y=3318, floor=1))
    private val TableOneBuild = Furniture(40070, "Build", Tile(x=2657, y=3318, floor=1))
    private val TableTwoRemove = Furniture(40108, "Remove", Tile(x=2654, y=3320, floor=1))
    private val TableTwoBuild = Furniture(40070, "Build", Tile(x=2654, y=3320, floor=1))
    private val DrawersRemove = Furniture(40181, "Remove", Tile(x=2657, y=3322, floor=1))
    private val DrawersBuild = Furniture(40082, "Build", Tile(x=2657, y=3322, floor=1))
    private val GrandfatherClock = Furniture(40141, "Repair", Tile(x=2653, y=3322, floor=1))
    private val LadderTwo = Furniture(16685, "Climb-down", Tile(x=2655, y=3322, floor=1))

    val AllNoella = listOf(
        HatStand, Mirror, CupboardRemove, CupboardBuild, DresserRemove, DresserBuild,
        Staircase, LadderOne, TableOneRemove, TableOneBuild, TableTwoRemove, TableTwoBuild, DrawersRemove, DrawersBuild,
        GrandfatherClock, LadderTwo)
}

object Norman {
    private val Range = Furniture(40148, "Repair", Tile(x=3040, y=3346, floor=0))
    private val TableOneRemove = Furniture(40102, "Remove", Tile(x=3036, y=3343, floor=0))
    private val TableOneBuild = Furniture(40070, "Build", Tile(x=3036, y=3343, floor=0))
    private val GrandfatherClock = Furniture(40141, "Repair", Tile(x=3035, y=3346, floor=0))
    private val Ladder = Furniture(24082, "Climb-up", Tile(x=3035, y=3344, floor=0))
    private val DrawersRemove = Furniture(40143, "Remove", Tile(x=3035, y=3347, floor=1))
    private val DrawersBuild = Furniture(40082, "Build", Tile(x=3035, y=3347, floor=1))
    private val BookshelfRemove = Furniture(40134, "Remove", Tile(x=3035, y=3346, floor=1))
    private val BookshelfBuild = Furniture(40074, "Build", Tile(x=3035, y=3346, floor=1))
    private val TableTwoRemove = Furniture(39967, "Remove", Tile(x=3040, y=3345, floor=1))
    private val TableTwoBuild = Furniture(40069, "Build", Tile(x=3040, y=3345, floor=1))
    private val BedRemove = Furniture(40128, "Remove", Tile(x=3040, y=3347, floor=1))
    private val BedBuild = Furniture(40080, "Build", Tile(x=3040, y=3347, floor=1))

    val AllNorman = listOf(
        Range, TableOneRemove, TableOneBuild, GrandfatherClock, Ladder, DrawersRemove, DrawersBuild, BookshelfRemove,
        BookshelfBuild, TableTwoRemove, TableTwoBuild, BedRemove, BedBuild
    )
}

object Ross {
    private val DoorOne = Furniture(1540, "Open", Tile(x=2615, y=3315, floor=1))
    private val BedOneRemove = Furniture(40200, "Remove", Tile(x=2614, y=3318, floor=1))
    private val BedOneBuild = Furniture(40080, "Build", Tile(x=2614, y=3318, floor=1))
    private val DoorTwo = Furniture(1540, "Open", Tile(x=2616, y=3317, floor=1))
    private val BedTwoRemove = Furniture(40207, "Remove", Tile(x=2618, y=3319, floor=1))
    private val BedTwoBuild = Furniture(40081, "Build", Tile(x=2618, y=3319, floor=1))
    private val Mirror = Furniture(40179, "Repair", Tile(x=2618, y=3317, floor=1))
    private val HatStand = Furniture(40139, "Repair", Tile(x=2615, y=3316, floor=1))
    private val Ladder = Furniture(16679, "Climb-down", Tile(x=2617, y=3315, floor=1))
    private val Range = Furniture(40148, "Repair", Tile(x=2617, y=3318, floor=0))
    private val DrawersOneRemove = Furniture(40187, "Remove", Tile(x=2611, y=3318, floor=0))
    private val DrawersOneBuild = Furniture(40082, "Build", Tile(x=2611, y=3318, floor=0))
    private val DrawersTwoRemove = Furniture(40187, "Remove", Tile(x=2611, y=3315, floor=0))
    private val DrawersTwoBuild = Furniture(40082, "Build", Tile(x=2611, y=3315, floor=0))

    val AllRoss = listOf(
        DoorOne, BedOneRemove, BedOneBuild, DoorTwo, BedTwoRemove, BedTwoBuild, Mirror, HatStand, Ladder, Range,
        DrawersOneRemove, DrawersOneBuild, DrawersTwoRemove, DrawersTwoBuild
    )
}

object Sarah {
    private val TableOneRemove = Furniture(39967, "Remove", Tile(x=3233, y=3382, floor=0))
    private val TableOneBuild = Furniture(40069, "Build", Tile(x=3233, y=3382, floor=0))
    private val BedRemove = Furniture(39974, "Remove", Tile(x=3234, y=3384, floor=0))
    private val BedBuild = Furniture(40081, "Build", Tile(x=3234, y=3384, floor=0))
    private val ShelvesRemove = Furniture(39935, "Remove", Tile(x=3234, y=3382, floor=0))
    private val ShelvesBuild = Furniture(40077, "Build", Tile(x=3234, y=3382, floor=0))
    private val Range = Furniture(40148, "Repair", Tile(x=3237, y=3382, floor=0))
    private val TableTwoRemove = Furniture(39961, "Remove", Tile(x=3237, y=3385, floor=0))
    private val TableTwoBuild = Furniture(40070, "Build", Tile(x=3237, y=3385, floor=0))
    private val DresserRemove = Furniture(39948, "Remove", Tile(x=3234, y=3386, floor=0))
    private val DresserBuild = Furniture(40076, "Build", Tile(x=3234, y=3386, floor=0))


    val AllSarah = listOf(
        TableOneRemove, TableOneBuild, BedRemove, BedBuild, ShelvesRemove, ShelvesBuild, Range, TableTwoRemove,
        TableTwoBuild, DresserRemove, DresserBuild
    )
}

object Tau {
    private val SinkOne = Furniture(40100, "Repair", Tile(x=3051, y=3348, floor=0))
    //    val SinkTwo = Furniture(40023, "Repair", Tile(x=3051, y=3347, floor=0))
    private val TableOneRemove = Furniture(40108, "Remove", Tile(x=3049, y=3349, floor=0))
    private val TableOneBuild = Furniture(40070, "Build", Tile(x=3049, y=3349, floor=0))
    private val TableTwoRemove = Furniture(40102, "Remove", Tile(x=3048, y=3345, floor=0))
    private val TableTwoBuild = Furniture(40070, "Build", Tile(x=3048, y=3345, floor=0))
    private val CupBoardRemove = Furniture(40115, "Remove", Tile(x=3044, y=3345, floor=0))
    private val CupBoardBuild = Furniture(40078, "Build", Tile(x=3044, y=3345, floor=0))
    private val HatStand = Furniture(40139, "Repair", Tile(x=3046, y=3341, floor=0))
    private val ShelvesOneRemove = Furniture(40121, "Remove", Tile(x=3047, y=3341, floor=0))
    private val ShelvesOneBuild = Furniture(40077, "Build", Tile(x=3047, y=3341, floor=0))
    private val ShelvesTwoRemove = Furniture(40121, "Remove", Tile(x=3048, y=3341, floor=0))
    private val ShelvesTwoBuild = Furniture(40077, "Build", Tile(x=3048, y=3341, floor=0))

    val AllTau = listOf<Furniture>(
        SinkOne, TableOneRemove, TableOneBuild, TableTwoRemove, TableTwoBuild, CupBoardRemove,
        CupBoardBuild, HatStand, ShelvesOneRemove, ShelvesOneBuild, ShelvesTwoRemove, ShelvesTwoBuild
    )
}