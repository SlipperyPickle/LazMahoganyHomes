package branch

import Script
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class HasContract(script: Script) : Branch<Script>(script, "HasContract") {
    override val successComponent: TreeComponent<Script> = IsInHome(script)
    override val failedComponent: TreeComponent<Script> = ShouldWalkToAmy(script)

    override fun validate(): Boolean {
        return script.currentHome != null
    }
}
