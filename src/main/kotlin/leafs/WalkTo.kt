package leafs

import Constants.BANK_TILE
import Constants.NEW_CONTRACT_TILE
import Script
import homes.Homes
import org.powbot.api.Locatable
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf
import org.powbot.dax.api.DaxWalker
import org.powbot.dax.teleports.Teleport

class WalkTo(script: Script, private val location: Destination) : Leaf<Script>(script, "Walking") {

    override fun execute() {
        val destination: Locatable = when (location) {
            Destination.AMY -> NEW_CONTRACT_TILE
            Destination.BANK -> BANK_TILE
            Destination.FIRST_ROOM -> Homes.get(script.currentHome!!.name)!!.rooms[0].area.centralTile
            Destination.SECOND_ROOM -> Homes.get(script.currentHome!!.name)!!.rooms[1].area.centralTile
            Destination.HOME_OWNER -> Homes.get(script.currentHome!!.name)!!.npcLocation
        }


//        if (destination.distance() < 10 && destination.tile().floor == Players.local().floor()) {
//            return
//        }

        script.logger("WalkTo $location", "Walking to ${destination.tile()}")

        DaxWalker.removeBlacklistTeleports(
            Teleport.POH_OUTSIDE_HOSIDIUS,
            Teleport.POH_OUTSIDE_HOSIDIUS_TAB,
            Teleport.VARROCK_TELEPORT,
            Teleport.VARROCK_TELEPORT_TAB,
            Teleport.FALADOR_TELEPORT,
            Teleport.FALADOR_TELEPORT_TAB,
            Teleport.ARDOUGNE_TELEPORT,
            Teleport.ARDOUGNE_TELEPORT_TAB
        )

        Movement.builder(destination)
            .setAutoRun(true)
            .move()

    }
}

enum class Destination {
    AMY,
    BANK,
    FIRST_ROOM,
    SECOND_ROOM,
    HOME_OWNER
}