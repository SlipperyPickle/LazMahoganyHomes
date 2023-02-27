package branch

import Constants.HAMMER
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawHammer(script: Script) : Leaf<Script>(script, "WithdrawHammer") {
    override fun execute() {
        if (Bank.stream().id(HAMMER).isNotEmpty()) {
            Bank.withdraw(HAMMER, 1)
            Condition.wait { Inventory.stream().id(HAMMER).isNotEmpty() }
        } else {
            Notifications.showNotification("No hammer, stopping")
            script.logger("WithdrawHammer", "Now saw, stopping")
            ScriptManager.stop()
        }
    }
}

