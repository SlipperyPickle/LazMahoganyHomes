package leafs

import Script
import homes.Homes
import homes.HomesOld
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.Logger

class FirstLeaf(script: Script) : Leaf<Script>(script, "Firstleaf") {
    override fun execute() {
//        //TODO
//        if (Players.local().tile().distanceTo(Homes.get("Jess")?.location) > 1) {
//
//        }
        val walkTile = HomesOld.valueOf("Jess").location.centralTile

//            Movement.builder(Homes.get("Jess")?.location).move()
        script.logger.info("TILE ======" + walkTile)
//        println("TEST")
    }
}