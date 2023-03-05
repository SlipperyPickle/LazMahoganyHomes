package branch

import Constants.NEW_CONTRACT_TILE
import Constants.PLANK_SACK
import Script
import leafs.CheckPlankSack
import leafs.Destination
import leafs.TalkToAmy
import leafs.WalkTo
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class ShouldWalkToAmy(script: Script) : Branch<Script>(script, "ShouldWalkToAmy") {
    override val successComponent: TreeComponent<Script> = WalkTo(script, Destination.AMY)
    override val failedComponent: TreeComponent<Script> = ShouldCheckPlankSack(script)

    override fun validate(): Boolean {
        return NEW_CONTRACT_TILE.distance() > 10
    }
}

class ShouldCheckPlankSack(script: Script) : Branch<Script>(script, "ShouldCheckPlankSack") {
    override val successComponent: TreeComponent<Script> = CheckPlankSack(script)
    override val failedComponent: TreeComponent<Script> = TalkToAmy(script)

    override fun validate(): Boolean {
        return script.usePlankSack && script.plankSackNumber < 0 &&
                Inventory.stream().id(PLANK_SACK).isNotEmpty() && !Bank.opened()
    }
}

