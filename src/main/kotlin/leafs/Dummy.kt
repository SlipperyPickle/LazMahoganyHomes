package leafs

import Script
import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class Dummy(script: Script) : Leaf<Script>(script, "Dummy") {

    override fun execute() {
//        script.logger.info("Door at cabinet? ${Objects.doorInBetween(7420)}")
//        script.logger.info("Door at bath? ${Objects.doorInBetween(40213)}")
//        Tile(3235, 3490, 1), new Tile(3242, 3483, 1)
        val tile = Area(Tile(3235, 3490, 1), Tile(3242, 3483, 1)).centralTile
        Movement.walkTo(tile)
    }
}


