package leafs

import Constants.PLANK_SACK
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawPlanks(script: Script) : Leaf<Script>(script, "WithdrawPlanks") {
    override fun execute() {
        val home = script.currentHome!!
        val planks = Bank.stream().id(home.getPlank(script.currentTier))

        if (planks.count(true) < 40) {
            Notifications.showNotification("Not enough planks, stopping")
            script.logger("WithdrawPlanks", "Not enough planks, stopping")
            ScriptManager.stop()
        }

        if (script.usePlankSack) {
            if (Inventory.stream().id(PLANK_SACK).isEmpty()) {
                val plankSack = Bank.stream().id(PLANK_SACK)
                if (plankSack.isEmpty()) {
                    Notifications.showNotification("No planksack detected, stopping")
                    script.logger("WithdrawPlanks", "No planksack detected, stopping")
                    ScriptManager.stop()
                } else {
                    Bank.withdraw(PLANK_SACK, 1)
                    Condition.wait{ Inventory.stream().id(PLANK_SACK).isNotEmpty() }
                }
            }
            val plankSack = Inventory.stream().id(PLANK_SACK).first()
            repeat(2) {
                Bank.withdraw(home.getPlank(script.currentTier), Bank.Amount.ALL)
                Condition.wait { Inventory.isFull() }
                Bank.close()
                Condition.wait { !Bank.opened() }
                plankSack.interact("Fill")
                Condition.wait { !Inventory.isFull() }
                Bank.open()
                Condition.wait { Bank.opened() }
            }
        }
        if (!Inventory.isFull()) {
            Bank.withdraw(home.getPlank(script.currentTier), Bank.Amount.ALL)
        }
    }
}


