package branch

import Constants.NEW_CONTRACT_TILE
import Script
import leafs.Destination
import leafs.TalkToAmy
import leafs.WalkTo
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldWalkToAmy(script: Script) : Branch<Script>(script, "ShouldWalkToAmy") {
    override val successComponent: TreeComponent<Script> = WalkTo(script, Destination.AMY)
    override val failedComponent: TreeComponent<Script> = TalkToAmy(script)

    override fun validate(): Boolean {
        return NEW_CONTRACT_TILE.distance() > 10
    }
}