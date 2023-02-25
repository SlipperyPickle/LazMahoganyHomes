package leafs

import Script
import homes.Homes
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Item
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawPlanks(script: Script) : Leaf<Script>(script, "WithdrawPlanks") {

    override fun execute() {
        val planks = Bank.stream().id(Homes.currentPlank(script.contractTier)).first()
        if (planks == Item.Nil || planks.stackSize() < 15) {
            Notifications.showNotification("Out of planks, stopping")
            ScriptManager.stop()
            return
        }
        if (Bank.withdraw(Homes.currentPlank(script.contractTier), Bank.Amount.ALL)) {
            Condition.wait { Inventory.isFull() }
        }
    }
}
