package leafsOld

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import extensions.doorInBetween
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Widgets
import org.powbot.api.rt4.walking.local.Utils.getWalkableNeighbors
import org.powbot.api.script.tree.Leaf

class FixOld(script: Script, private var room: Int) : Leaf<Script>(script, "Fix") {
    override fun execute() {
        if (room == 1) {
            room = when (script.currentHome) {
                Homes.JESS -> 0
                Homes.TAU -> 0
                Homes.BARBARA -> 0
                Homes.SARAH -> 0
                else -> 1
            }
        }
        val buildWidget =
            Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.currentTier)
        if (buildWidget.visible() && buildWidget.interact("Build")) {
            Condition.wait {
                !Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.currentTier)
                    .visible() && Players.local().animation() == -1
            }
        } else {
            val furnitureIds = Homes.get(script.currentHome!!.name)!!.rooms[room].objects
            val furnitureObject = Objects.stream().id(*furnitureIds).filtered { it.distance() < 15 }.nearest().first()

            val walkableTile = furnitureObject.getWalkableNeighbors(allowSelf = true)
                .minByOrNull { it.distanceTo(Players.local().tile()) }
            if (script.currentHome == Homes.BARBARA){
                val door = Objects.stream().name("Door").action("Open").filtered { it.distance() < 10 }.first()
                if (door.valid()) {
                    door.interact("Open")
                    Condition.wait( {door.actions().contains("Close") }, 400, 10)
                }
            }
            if (furnitureObject.valid()) {
                //NOT bob,
                when (script.currentHome) {
                    Homes.JESS, Homes.MARIAH, Homes.JEFF -> Objects.doorInBetween(furnitureObject.id)
                    else -> {}
                }

//                if (Objects.doorInBetween(furnitureObject.id)) {
//                    Objects.getDoor(furnitureObject.id)!!.interact("Open")
                if (furnitureObject.inViewport() && furnitureObject.click()) {
                    Condition.wait { !Players.local().inMotion() && Players.local().animation() == -1 }

                } else {
                    Movement.step(walkableTile!!)
                }
            } else {
                script.firstFloorDone = true
            }

        }
    }
}

