package leafs

import Script
import org.powbot.api.Tile
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class Dummy(script: Script) : Leaf<Script>(script, "Dummy") {
//    override fun execute() {
//        val buildWidget =
//            Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.contractTier)
//        if (buildWidget.visible()) {
//            if (buildWidget.interact("Build")) {
//                !Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT).visible() &&
//                        Players.local().animation() == -1
//            }
//        }
////        val actions = arrayOf("Remove", "Build", "Repair")
//
//
////        while (Homes.furnitureLeft() > 0) {
//        //TODO
//        val ids = script.currentHome!!.objects
//
//        val furniture = Objects.stream().id(*ids).reachable().nearest().first()
//        script.log.info("furniture: $furniture")
//        script.log.info("ids: ${ids.toList()}")
//
//        if (!furniture.valid()) {
//
//            script.logger.info("Not valid")
//        }
//
//        if (furniture.valid() && furniture.tile.distance() < 10) {
//            script.logger.info("Valid")
//            if (furniture.inViewport()) {
//                script.logger.info("inViewport")
//                if (furniture.click()) {
//                    script.logger.info("Click")
//                    Condition.wait {
//                        Players.local().animation() == -1 || Widgets.widget(BUILD_FURNITURE_WIDGET).component(
//                            BUILD_FURNITURE_COMPONENT
//                        ).visible()
//                    }
//                }
//            }
////                else {
////                    Camera.turnTo(furniture)
////                }
//        }
////            else {
////                Movement.step(furniture)
////            }
////            if (!furniture.valid()) {
////                val stairs = Objects.stream().action("Climb").first()
////                if (stairs.valid() && stairs.tile.distance() < 10 && stairs.inViewport()) {
////                    val floor = Players.local().floor()
////                    if (stairs.click()) {
////                        Condition.wait ({ Players.local().floor() != floor }, 250, 20)
////                    }
////                }
////            }
////        }
//    }
    override fun execute() {
//        TODO("Not yet implemented")
        val tileUp = Tile(1766, 3620, 1)
        if (tileUp.distance() > 1) {
            Movement.moveTo(tileUp)
        }
    }
}


