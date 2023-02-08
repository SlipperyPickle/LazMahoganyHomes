package branch

import Script
import leafs.FirstLeaf
import leafs.SecondLeaf
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class FirstBranch(script: Script) : Branch<Script>(script, "First branch") {
    override val successComponent: TreeComponent<Script> = FirstLeaf(script)
    override val failedComponent: TreeComponent<Script> = SecondLeaf(script)

    override fun validate(): Boolean {
        return true
    }
}