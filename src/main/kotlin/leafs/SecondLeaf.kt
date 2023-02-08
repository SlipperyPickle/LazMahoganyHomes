package leafs

import Script
import homes.HomesOld
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.Logger

class SecondLeaf(script: Script) : Leaf<Script>(script, "Firstleaf") {
    override fun execute() {
        //TODO
        val walkTile = HomesOld.valueOf("Jess").location.centralTile

//            Movement.builder(Homes.get("Jess")?.location).move()
        script.logger.info("TILE = $walkTile")
    }
}