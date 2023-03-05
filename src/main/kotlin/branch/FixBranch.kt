package branch

import Script
import homes.Homes
import leafs.Destination
import leafs.Fix
import leafs.TalkToHomeOwner
import leafs.WalkTo
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.SimpleLeaf
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
    override val failedComponent: TreeComponent<Script> = ShouldChangeCamera(script)

    override fun validate(): Boolean {
        return Homes.furnitureLeft() == 0
    }
}

class ShouldChangeCamera(script: Script) : Branch<Script>(script, "ShouldChangeCamera") {
    override val successComponent: TreeComponent<Script> = SimpleLeaf(script, "ChangeCamera") {
        Camera.moveZoomSlider(25.0)
    }
    override val failedComponent: TreeComponent<Script> = Fix(script)

    override fun validate(): Boolean {
        return Camera.zoom > 35
    }
}

class IsNearHomeOwner(script: Script) : Branch<Script>(script, "IsNearHomeOwner") {
    override val successComponent: TreeComponent<Script> = TalkToHomeOwner(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.HOME_OWNER)

    override fun validate(): Boolean {
        val homeOwner = Npcs.stream().name(script.currentHome!!.name).nearest().first()
        return homeOwner.valid() && homeOwner.inViewport()
    }
}


