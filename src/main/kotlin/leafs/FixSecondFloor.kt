package leafs

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf

class FixSecondFloor(script: Script) : Leaf<Script>(script, "FixSecondFloor") {

    @Deprecated("OLD")
    override fun execute() {
//        TODO("Not yet implemented")
        val buildWidget = Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.contractTier)
        if (buildWidget.visible()) {
            if (buildWidget.interact("Build")) {
                !Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.contractTier).visible() &&
                        Players.local().animation() == -1
            }
        } else {
            val furnitureIds = Homes.get(script.currentHome!!.name)!!.rooms[1].objects
            val furnitureObject = Objects.stream().id(*furnitureIds).nearest().first()
            if (furnitureObject.valid() && furnitureObject.inViewport() && furnitureObject.click()) {
                Condition.wait { !Players.local().inMotion() && Players.local().animation() == 1 }
            }
        }
    }
}


