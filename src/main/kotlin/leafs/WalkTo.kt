package leafs

import Constants.NEW_CONTRACT_TILE
import Script
import homes.Homes
import org.powbot.api.Locatable
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf
import org.powbot.dax.teleports.Teleport

class WalkTo(script: Script, val location: Destination) : Leaf<Script>(script, "Walking") {

    override fun execute() {
        val destination: Locatable = when (location) {
            Destination.AMY -> NEW_CONTRACT_TILE
            Destination.BANK -> Bank.nearest()
            Destination.FIRST_FLOOR -> Homes.get(script.currentHome!!.name)!!.rooms[0].area.centralTile
            Destination.SECOND_FLOOR -> Homes.get(script.currentHome!!.name)!!.rooms[1].area.centralTile
        }

        script.logger.info("Varp: ${Varpbits.value(2187)}")
        script.logger.info("getRequirement().satisfies:  ${Teleport.HOSIDIUS_TELEPORT_TAB.requirement.satisfies(
            Inventory.stream().list(), Equipment.stream().list()
        )}")
        script.logger.info("getRequirement().satisfies:  ${Teleport.POH_OUTSIDE_HOSIDIUS.requirement.satisfies(
            Inventory.stream().list(), Equipment.stream().list()
        )}")

        if (!Movement.builder(destination).setWalkUntil { destination.distance() < 5 && !Players.local().inMotion() }
                .setAutoRun(true).move().success) {
            Movement.step(destination)
        }
    }
}

enum class Destination {
    AMY,
    BANK,
    FIRST_FLOOR,
    SECOND_FLOOR
}