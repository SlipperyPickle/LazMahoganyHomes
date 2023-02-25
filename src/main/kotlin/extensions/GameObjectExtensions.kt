package extensions

import org.powbot.api.Condition
import org.powbot.api.Tile
import org.powbot.api.rt4.GameObject
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.walking.local.Utils.getWalkableNeighbors
import org.powbot.dax.api.DaxWalker
import org.powbot.dax.teleports.Teleport
import java.util.logging.Logger

fun Objects.doorInBetween(id: Int): Boolean {
    val logger: Logger = Logger.getLogger(this.javaClass.simpleName)

    val obj = stream().id(id).nearest().first()
    val walkableTile = obj.getWalkableNeighbors(allowSelf = true, diagonalTiles = false, checkForWalls = true).minByOrNull { it.distanceTo(Players.local().tile()) }
    DaxWalker.blacklistTeleports(*Teleport.values())
    lateinit var tiles: List<Tile>
    try {
        tiles = DaxWalker.getPath(walkableTile)
    } catch (e: NullPointerException) {
        return false
    }


    if (tiles == null ||!obj.valid() || walkableTile == null  || tiles.size > 20) {
        return false
    }

    val doors = stream().name("Door").action("Open")
    for (door in doors) {
        for (tile in tiles) {
            if (door.tile == tile) {
                logger.info("Door found at ${door.tile}")
                if (door.interact("Open")) {
                    Condition.wait { door.actions().contains("Close") }
                }
                return true
            }
        }
    }
    return false
}

fun Objects.getDoor(id: Int): GameObject? {
    val obj = stream().id(id).nearest().first()
    val walkableTile = obj.getWalkableNeighbors(allowSelf = true).minByOrNull { it.distanceTo(Players.local().tile()) }
    val tiles = DaxWalker.getPath(walkableTile)

    if (!obj.valid() || walkableTile == null || tiles.size > 20) {
        return null
    }

    val doors = stream().name("Door").action("Open")
    for (door in doors) {
        for (tile in tiles) {
            if (door.tile == tile) {
                return door
            }
        }
    }
    return null
}




//fun test(furnitureIds: IntArray) {
//    val furnitureObject = Objects.stream().id(*furnitureIds).filtered { it -> it.distance() < 10 }.nearest().first()
//    if (furnitureObject.valid()) {
//        if (!furnitureObject.getWalkableNeighbor()!!.tile().reachable()) {
//            val door = Objects.stream().name("Door").action("Open").nearest().first()
//            if (door.valid() && door.inViewport() && door.interact("Open")) {
//                Condition.wait { Players.local().animation() == -1 }
//            }
//            Movement.moveTo(Tile(2614, 3294, 1))
//        }
//    }
//}