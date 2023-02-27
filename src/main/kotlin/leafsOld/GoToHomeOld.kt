package leafsOld

import Script
import homes.Homes
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class GoToHomeOld(script: Script) : Leaf<Script>(script, "GoToHome") {

    @Deprecated("OLD")
    override fun execute() {
        val homeTile = Homes.get(script.currentHome!!.name)!!.rooms[0].area.centralTile

        if (!Movement.builder(homeTile)
                .setRunMin(10)
                .setRunMax(20)
                .setWalkUntil { Homes.inCurrentHome(script.currentHome!!.home) }
                .move().success
        ) {
            Movement.step(Bank.nearest())
        }
    }
}


