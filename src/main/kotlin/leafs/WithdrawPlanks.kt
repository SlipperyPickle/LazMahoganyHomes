package leafs

import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.PLANK_SACK
import Constants.TEAK_PLANK
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
                    script.usePlankSack = false
                } else {
                    Bank.withdraw(PLANK_SACK, 1)
                    Condition.wait{ Inventory.stream().id(PLANK_SACK).isNotEmpty() }
                }
            }
            val plankSack = Inventory.stream().id(PLANK_SACK).first()
            repeat(2) {
                if (ScriptManager.isStopping()) {
                    return
                }
                Bank.withdraw(home.getPlank(script.currentTier), Bank.Amount.ALL)
                Condition.wait { Inventory.isFull() }
                plankSack.interact("Use")
                Condition.wait ({ !Inventory.isFull() }, 100, 10)
            }
        }
        if (!Inventory.isFull()) {
            Bank.withdraw(home.getPlank(script.currentTier), Bank.Amount.ALL)
        }

        val invCount = Inventory.stream().id(PLANK, OAK_PLANK, TEAK_PLANK, MAHOGANY_PLANK).count().toInt()
        script.plankSackNumber = if (script.usePlankSack) 28 + invCount else invCount
        Bank.close()
    }
}


