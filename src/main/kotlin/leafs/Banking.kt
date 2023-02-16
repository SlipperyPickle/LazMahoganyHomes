package leafs

import Constants.OAK_PLANK
import Constants.STEEL_BAR
import Script
import homes.RequiredItems
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class Banking(script: Script) : Leaf<Script>(script, "Banking") {
    override fun execute() {
        if (Bank.nearest().distance() > 7) {
            Movement.moveToBank()
        } else {
            if (Bank.inViewport() && Bank.open()) {
                Condition.wait { Bank.opened() }
            } else {
                Camera.turnTo(Bank.nearest().tile())
            }
        }

        if (Bank.opened()) {
            val barsToWithdraw = script.steelBars - Inventory.stream().id(STEEL_BAR).toList().size

            if (Bank.stream().id(STEEL_BAR).isEmpty() ||
                Bank.stream().id(RequiredItems.getPlank(script.contractTier)).isEmpty()) {
                ScriptManager.stop()
            }

            if (barsToWithdraw != 0 && Bank.withdraw(STEEL_BAR, barsToWithdraw)) {
                Condition.wait { Inventory.stream().id(STEEL_BAR).toList().size == script.steelBars }
            }
            if (Bank.withdraw(OAK_PLANK, Inventory.emptySlotCount())) {
                Condition.wait { Inventory.isFull() }
            }

            Bank.close()
        }
    }
}


