package branch

import Constants.AMYS_SAW
import Constants.CONTRACT_FINISH
import Constants.SAW
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawSaw(script: Script) : Leaf<Script>(script, "WithdrawSaw") {

    override fun execute() {
        val sawID = when (script.amysSaw) {
            true -> AMYS_SAW
            false -> SAW
        }
        if (Bank.stream().id(sawID).isNotEmpty()) {
            Bank.withdraw(sawID, 1)
            Condition.wait { Inventory.stream().id(sawID).isNotEmpty() }
        } else {
            Notifications.showNotification("No saw, stopping")
            script.logger("WithdrawSaw", "Now saw, stopping")
            ScriptManager.stop()
        }
    }
}


