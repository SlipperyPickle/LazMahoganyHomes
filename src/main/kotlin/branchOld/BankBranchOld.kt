package branchOld

import Constants.STEEL_BAR
import Script
import homes.Homes
import leafs.Destination
import leafs.WalkTo
import leafsOld.*
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class InCurrentHome(script: Script): Branch<Script>(script, "InCurrentHome?") {
    override val successComponent: TreeComponent<Script> = IsFirstFloorDone(script)
    override val failedComponent: TreeComponent<Script> = HasItems(script)

    override fun validate(): Boolean {
        return (script.currentHome != null && Homes.inCurrentHome(script.currentHome!!.name))
    }
}

class HasItems(script: Script) : Branch<Script>(script, "HasItems?") {
    override val successComponent: TreeComponent<Script> = IsAtFirstFloor(script)
    override val failedComponent: TreeComponent<Script> = BankOpenedOld(script)

    private fun hasRequiredItems(): Boolean {
        val currentTier = script.currentTier
        val home = script.currentHome?.name
//        if (!home.isNullOrEmpty()) {
//            val itemsNeeded = Homes.requiredItems(home, currentTier)
//
//            val numberSteelBars = Inventory.stream().id(STEEL_BAR).toList().size
//            script.logger.info(
//                "Current steel bars: $numberSteelBars number of planks: ${
//                    Inventory.stream().id(Inventory.stream().id(TEAK_PLANK).toList().size)
//                }"
//            )
//
//            when (currentTier) {
//                0 -> return ((Inventory.stream().id(PLANK).toList().size >= itemsNeeded!![0]) &&
//                        (numberSteelBars >= itemsNeeded[1]))
//
//                1 -> return ((Inventory.stream().id(OAK_PLANK).toList().size >= itemsNeeded!![0]) &&
//                        (numberSteelBars >= itemsNeeded[1]))
//
//                2 -> return ((Inventory.stream().id(TEAK_PLANK).toList().size >= itemsNeeded!![0]) &&
//                        (numberSteelBars >= itemsNeeded[1]))
//
//                3 -> return ((Inventory.stream().id(MAHOGANY_PLANK).toList().size >= itemsNeeded!![0]) &&
//                        (numberSteelBars >= itemsNeeded[1]))
//            }
//        }
        return false
    }

    override fun validate(): Boolean {
        return hasRequiredItems()
    }
}
class BankOpenedOld(script: Script) : Branch<Script>(script, "BankOpened") {
    override val successComponent: TreeComponent<Script> = ShouldWithdrawBarsOld(script)
    override val failedComponent: TreeComponent<Script> = IsNearBankOld(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}

class IsNearBankOld(script: Script) : Branch<Script>(script, "IsNearBank") {
    override val successComponent: TreeComponent<Script> = BankingOld(script) //SimpleLeaf(script, "OpenBank") { if (!Bank.open()) Camera.angleToLocatable(Bank.nearest()) }
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.BANK)

    override fun validate(): Boolean {
        val bank = Bank.nearest()
        return bank.distance() < 10 && bank.tile().matrix().inViewport()
    }
}

class ShouldWithdrawBarsOld(script: Script) : Branch<Script>(script, "ShouldWithdrawBars") {
    override val successComponent: TreeComponent<Script> = WithdrawBarsOld(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawPlanksOld(script)

    override fun validate(): Boolean {
        return (2 - Inventory.stream().id(STEEL_BAR).count()) > 0
    }
}

class ShouldWithdrawPlanksOld(script: Script) : Branch<Script>(script, "ShouldWithdrawPlanks") {
    override val successComponent: TreeComponent<Script> = WithdrawPlanksOld(script)
    override val failedComponent: TreeComponent<Script> = IsNearBankOld(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}