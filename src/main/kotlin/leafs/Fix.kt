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
import org.powbot.mobile.script.ScriptManager

class Fix(script: Script) : Leaf<Script>(script, "Fix") {
    override fun execute() {

        val furnitures = script.currentHome!!.furniture

        for (furniture in furnitures) {
            if (ScriptManager.isStopping()) {
                return
            }
            val obj = Objects.stream().id(furniture.id).at(furniture.tile).action(furniture.action).nearest().first()

            if (obj.valid() && obj.interact(furniture.action)) {
                if (script.currentHome == Homes.NOELLA && obj.distance() >= 7) continue


                val wid = Widgets.widget(BUILD_FURNITURE_WIDGET).component(
                    BUILD_FURNITURE_COMPONENT +
                            script.currentTier
                )
                if (furniture.action == "Build") {
                    Condition.wait({ wid.refresh().visible() }, 100, 40)
                } else {
                    Condition.wait({ !obj.refresh().valid() && Players.local().animation() == -1 }, 300, 20)
                }
                if (wid.refresh().visible() && wid.refresh().interact("Build")) {
                    Condition.wait({ !wid.refresh().visible() && (Players.local().animation() == -1) },200, 20)
                }
            }

            if (obj.refresh().valid()) {
                return
            }
        }
    }
}

//        furniture.forEach forEach@{
//            if (ScriptManager.isStopping()) {
//                return
//            }
//
//            val obj = Objects.stream().id(it.id).at(it.tile).action(it.action).nearest().first()
//            if (script.currentHome == Homes.NOELLA && obj.distance() > 8) return@forEach
//
//            if (obj.valid() && obj.interact(it.action)) {
//                val wid = Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT +
//                        script.currentTier)
//                if (it.action == "Build") {
//                    Condition.wait ({ wid.refresh().visible() }, 100, 40)
//                }
//                else {
//                    Condition.wait ({ !obj.refresh().valid() && Players.local().animation() == -1 }, 300, 20)
//                }
//                if (wid.refresh().visible()) {
//                    if (wid.refresh().interact("Build")) {
//                        Condition.wait ({ !wid.refresh().visible() && Players.local().animation() == -1 },
//                            200, 20)
//                    }
//                }
//            }
//            if (obj.refresh().valid()) {
//                return
//            }
//        }