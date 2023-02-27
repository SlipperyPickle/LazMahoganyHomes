package branchOld

import Constants.NEW_CONTRACT_TILE
import Script
import leafs.Destination
import leafsOld.GetContractOld
import leafs.WalkTo
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class IsAtAmy(script: Script) : Branch<Script>(script, "IsAtAmy") {
    override val successComponent: TreeComponent<Script> = GetContractOld(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.AMY)

    override fun validate(): Boolean {
        return NEW_CONTRACT_TILE.distance() < 7
    }
}