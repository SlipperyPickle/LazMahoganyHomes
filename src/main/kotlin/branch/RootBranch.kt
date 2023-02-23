package branch

import Script
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class HasContract(script: Script) : Branch<Script>(script, "HasContract") {
    override val successComponent: TreeComponent<Script> = HasItems(script)
    override val failedComponent: TreeComponent<Script> = IsAtAmy(script)

    override fun validate(): Boolean {
        return script.currentHome != null
    }
}
