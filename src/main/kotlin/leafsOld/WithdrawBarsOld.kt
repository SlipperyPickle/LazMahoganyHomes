package leafsOld

import Constants.STEEL_BAR
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Item
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class WithdrawBarsOld(script: Script) : Leaf<Script>(script, "WithdrawBars") {

    override fun execute() {
        val bars = Bank.stream().id(STEEL_BAR).first()
        if (bars == Item.Nil || bars.stackSize() < 3) {
            Notifications.showNotification("Out of bars, stopping")
            ScriptManager.stop()
            return
        }
        if (Bank.withdraw(STEEL_BAR, script.steelBars - Inventory.stream().id(STEEL_BAR).count().toInt() )) {
            Condition.wait { Inventory.stream().id(STEEL_BAR).count() > 0 }
        }

    }
}

//if (Bank.opened()) {
//            if (Bank.stream().id(STEEL_BAR).isEmpty() ||
//                Bank.stream().id(RequiredItems.getPlank(script.contractTier)).isEmpty()) {
//                ScriptManager.stop()
//            }
//
//
//            Bank.close()
//
//        } else {
//            if (Bank.open()) {
//                Condition.wait({Bank.opened()}, 250, 15)
//            }
//        }
//        if (!Movement.builder(Bank.nearest())
//            .setRunMin(10)
//            .setRunMax(20)
//            .setWalkUntil { Bank.nearest().distance() < 7 && Bank.inViewport() }
//            .move().success) {
//            Movement.step(Bank.nearest())
//        }
