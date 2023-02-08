package homes

import org.powbot.api.Area
import org.powbot.api.Tile

enum class Homes(
    val home: String,
    val location: Tile,
    val requiredItems: RequiredItems
) {
    JESS(
        "Jess",
        Tile(3749, 5659, 0),
        RequiredItems.JESS
    ),

    NOELLA(
        "Noella",
        Tile(2653, 3323, 0),
        RequiredItems.NOELLA
    );

    companion object {
        fun get(name: String): Homes? = values().firstOrNull { it.name.equals(name, true) }
    //            val name2 =  values().firstOrNull { it.name.equals(name, true)}
//            System.out.println(name2.toString())

        fun getLocation(name: String): Tile? = values().firstOrNull { it.name.equals(name, true) }?.location
    }
}

