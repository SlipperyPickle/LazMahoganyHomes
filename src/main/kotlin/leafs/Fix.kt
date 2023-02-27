package leafs

import Script
import extensions.doorInBetween
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class Fix(script: Script) : Leaf<Script>(script, "Fix") {
    override fun execute() {
        val room = if (script.firstFloorDone) 1 else 0
        val furnitureIds = Homes.get(script.currentHome!!.name)!!.rooms[room].objects
        val furnitureObject = Objects.stream().id(*furnitureIds).filtered { it.distance() < 15 }.nearest().first()

        if (furnitureObject.valid()) {
            if (script.lastObject == furnitureObject.id) {
                Objects.doorInBetween(furnitureObject.id)
            } else {
                if (furnitureObject.inViewport() && furnitureObject.interact(furnitureObject.actions()[0])) {
                    Condition.wait { !Players.local().inMotion() && Players.local().animation() == -1 }
                }
                script.lastObject = furnitureObject.id()

            }
        } else {
            script.firstFloorDone = true
        }
    }
}


