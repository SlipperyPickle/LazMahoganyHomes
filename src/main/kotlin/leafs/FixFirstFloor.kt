package leafs

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf

class FixFirstFloor(script: Script) : Leaf<Script>(script, "FixFirstFloor") {

    @Deprecated("OLD")
    override fun execute() {
//        TODO("Not yet implemented")
        val buildWidget =
            Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.contractTier)
        if (buildWidget.visible()) {
            if (buildWidget.interact("Build")) {
                !Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.contractTier)
                    .visible() &&
                        Players.local().animation() == -1
            }
        } else {
            val furnitureIds = Homes.get(script.currentHome!!.name)!!.rooms[0].objects
            val furnitureObject = Objects.stream().id(*furnitureIds).nearest().first()
            if (furnitureObject.valid()) {
                if (furnitureObject.inViewport() && furnitureObject.click()) {
                    Condition.wait { !Players.local().inMotion() && Players.local().animation() == 1 }
                }
            } else {
                script.firstFloorDone = true
            }
        }
    }
}

