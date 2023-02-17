package leafs

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Objects
import org.powbot.api.rt4.Players
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf

class Dummy(script: Script) : Leaf<Script>(script, "Dummy") {
    override fun execute() {

        val actions = arrayOf("Remove", "Build", "Repair")
        val ids = script.currentHome!!.objects
        val furniture = Objects.stream().id(*ids).reachable().nearest().first()
        if (furniture.valid() && furniture.inViewport() && furniture.click()) {
            Condition.wait { Players.local().animation() == -1 || Widgets.widget(BUILD_FURNITURE_WIDGET).component(
                BUILD_FURNITURE_COMPONENT).visible() }
        }

//        script.logger.info("Count = ${Data.count()}")
        script.log.info("LOOGGG")
//        if ()
//        val stair = Objects.stream().action()

//        stair.m
//        Objects.stream().mi
    }
}


