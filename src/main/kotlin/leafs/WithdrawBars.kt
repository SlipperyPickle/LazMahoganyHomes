package leafs

import Constants.STEEL_BAR
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawBars(script: Script) : Leaf<Script>(script, "WithdrawBars") {
    override fun execute() {
        val numOfBars = script.steelBars - Inventory.stream().id(STEEL_BAR).count().toInt()
        if (Bank.stream().id(STEEL_BAR).count(true) > script.steelBars) {
            Bank.withdraw(STEEL_BAR, numOfBars)
            Condition.wait { Inventory.stream().id(STEEL_BAR).count().toInt() == script.steelBars}
        } else {
            Notifications.showNotification("No bars, stopping")
            script.logger("WithdrawBars", "Now bars, stopping")
            ScriptManager.stop()
        }
    }
}


