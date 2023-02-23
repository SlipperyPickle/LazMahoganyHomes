package branch

import Script
import homes.Homes
import leafs.*
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class IsFirstFloorDone(script: Script) : Branch<Script>(script, "IsFirstFloorDone") {
    override val successComponent: TreeComponent<Script> = IsSecondFloorDone(script)
    override val failedComponent: TreeComponent<Script> = IsAtFirstFloor(script)

    override fun validate(): Boolean {
        return script.firstFloorDone
    }
}

class IsAtFirstFloor(script: Script) : Branch<Script>(script, "IsAtFirstFloor") {
    override val successComponent: TreeComponent<Script> = FixFirstFloor(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.FIRST_FLOOR)

    override fun validate(): Boolean {
        val homeTile = Homes.get(script.currentHome!!.name)!!.rooms[0].area.centralTile
        return homeTile.distance() < 7
    }
}

class IsSecondFloorDone(script: Script) : Branch<Script>(script, "IsFirstFloorDone") {
    override val successComponent: TreeComponent<Script> = IsAtHomeOwner(script)
    override val failedComponent: TreeComponent<Script> = IsAtSecondFloor(script)

    override fun validate(): Boolean {
        return script.currentHome != null && Homes.furnitureLeft() == 0
    }
}

class IsAtSecondFloor(script: Script) : Branch<Script>(script, "IsAtSecondFloor") {
    override val successComponent: TreeComponent<Script> = FixSecondFloor(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.SECOND_FLOOR)

    override fun validate(): Boolean {
        val homeTile = Homes.get(script.currentHome!!.name)!!.rooms[1].area.centralTile
        return homeTile.distance() < 7
    }
}

class IsAtHomeOwner(script: Script) : Branch<Script>(script, "IsAtHomeOwner") {
    override val successComponent: TreeComponent<Script> = TalkToNPC(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.SECOND_FLOOR)

    override fun validate(): Boolean {
        return Homes.inCurrentHome(script.currentHome!!.name)
    }
}
