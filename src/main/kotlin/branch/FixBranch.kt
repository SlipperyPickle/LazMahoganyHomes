package branch

import Script
import homes.Homes
import leafs.Destination
import leafs.Fix
import leafs.TalkToHomeOwner
import leafs.WalkTo
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class IsInHome(script: Script) : Branch<Script>(script, "IsInHome") {
    override val successComponent: TreeComponent<Script> = IsHomeDone(script)
    override val failedComponent: TreeComponent<Script> = HasAllItems(script)

    override fun validate(): Boolean {
        return Homes.inCurrentHome(script.currentHome!!.name)
    }
}

class IsHomeDone(script: Script) : Branch<Script>(script, "IsHomeDone") {
    override val successComponent: TreeComponent<Script> = IsNearHomeOwner(script)
    override val failedComponent: TreeComponent<Script> = Fix(script)

    override fun validate(): Boolean {
        return Homes.furnitureLeft() == 0
    }
}

class IsNearHomeOwner(script: Script) : Branch<Script>(script, "IsNearHomeOwner") {
    override val successComponent: TreeComponent<Script> = TalkToHomeOwner(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.HOME_OWNER)

    override fun validate(): Boolean {
        val homeOwner = Npcs.stream().name(script.currentHome!!.name).firstOrNull()
        return homeOwner != null && homeOwner.inViewport()
    }
}
//
//class IsInCorrectRoom(script: Script) : Branch<Script>(script, "IsInCorrectRoom") {
//    override val successComponent: TreeComponent<Script> = Fix(script)
//    override val failedComponent: TreeComponent<Script> = if (script.firstFloorDone)
//                WalkTo(script, Destination.FIRST_ROOM) else
//                WalkTo(script, Destination.SECOND_ROOM)
//
//    override fun validate(): Boolean {
//        val home = script.currentHome!!.name
//        return Homes.inCorrectRoom(home, script.firstFloorDone)
//    }
//}




