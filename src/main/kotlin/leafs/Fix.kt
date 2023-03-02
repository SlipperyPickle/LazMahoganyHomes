package leafs

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import homes.Furniture
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class Fix(script: Script) : Leaf<Script>(script, "Fix") {
    override fun execute() {

        val furniture = Furniture.getFurniture(script.currentHome!!)
        furniture.forEach forEach@{
            if (ScriptManager.isStopping()) {
                return
            }

            val obj = Objects.stream().id(it.id).at(it.tile).action(it.action).nearest().first()
            if (script.currentHome == Homes.NOELLA && obj.distance() > 8) return@forEach
            script.logger("DUMMY", "tile on ${obj.name} on tile ${obj.tile}")

            if (obj.valid() && obj.interact(it.action)) {
                val wid = Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT +
                        script.currentTier)
                if (it.action == "Build") {
                    script.logger("DUMMY", "Waiting for widget")
                    Condition.wait ({ wid.refresh().visible() }, 200, 20)
                } else {
                    script.logger("DUMMY", "Waiting for object despawn")
                    Condition.wait ({ !obj.refresh().valid() && Players.local().animation() == -1 }, 200, 20)
                }
                if (wid.refresh().visible()) {
                    if (wid.refresh().interact("Build")) {
                        Condition.wait ({ !wid.refresh().visible() && Players.local().animation() == -1 }, 200, 20)
                    }
                }
            }
            if (obj.valid()) {
                return
            }
        }
    }
}


//        val room = if (script.firstFloorDone) 1 else 0
//        val furnitureIds = Homes.get(script.currentHome!!.name)!!.rooms[room].objects
//        val furnitureObject = Objects.stream().id(*furnitureIds).filtered { it.distance() < 15 }.nearest().first()
////        script.logger("Fix", "Found object: ${furnitureObject.valid()} name = ${furnitureObject.actions() } at ${furnitureObject.tile}")
////        script.logger("Fix", "Object actions sanitized: ${furnitureObject.actions().filter { it == "Remove" || it == "Build"|| it == "Repair" }[0]}")
//
//        if (furnitureObject.valid()) {
//            if (script.lastObject == furnitureObject.id) {
//                Objects.doorInBetween(furnitureObject.id)
//                script.lastObject = -1
//            } else {
//                val interact = furnitureObject.actions().forEach {  }
//                getInteraction(furnitureObject.actions())
//                val actions = arrayOf("Remove", "Build", "Repair")
//               if (furnitureObject.inViewport()) {
//                   for (action in actions) {
//                       if (furnitureObject.interact(action)) {
//                           Condition.wait { !Players.local().inMotion() && Players.local().animation() == -1 }
//                           script.lastObject = furnitureObject.id()
//                       }
//                   }
//               }
//
//
//
//
//            }
//        } else {
//            script.firstFloorDone = true
//        }