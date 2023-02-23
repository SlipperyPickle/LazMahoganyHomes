package old

import Script
import org.powbot.api.script.tree.Leaf

@Deprecated("Use FixFirstFloor")
class ExecuteContract(script: Script) : Leaf<Script>(script, "ExecuteContract") {
    override fun execute() {
//        val contractTile = script.currentHome!!.locations[0]
//
//        if (contractTile.distance() > 10 || !contractTile.reachable()) {
//            script.logger.info("Walking to ${contractTile.toString()}")
//            val reg = Regex("Barbara|Leela|Mariah")
//            val name = script.currentHome?.home
//            if (name != null) {
//                if (name.matches(reg) && Objects.stream().id(PORTAL).isEmpty()) {
//                    val spell = Magic.Spell.TELEPORT_TO_HOUSE
//                    if (spell.canCast()) spell.cast("Outside")
//                    Condition.wait { Objects.stream().id(PORTAL).isNotEmpty() }
//                } else {
//                    script.logger.info("Regex match = ${name.matches(reg)} Portal not found: ${Objects.stream().id(PORTAL).isEmpty()}")
//                }
//            } else {
//                script.logger.info("Name == null | $name")
//            }
//            Movement.walkTo(contractTile)
//        } else {
////            val objectIDs = intArrayOf(40172, 40173, 40174, 40171, 40176)
//            val objectIDs = intArrayOf(40187, 40212, 40141, 39899, 39905, 40187)
//            val objects = Objects.stream().id(*objectIDs)
//            script.logger.info("Number of objects found: ${objects.toList().lastIndex } Objects found: ${objects.toList().toString()}")
//        }
    }
}