package branch

import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.STEEL_BAR
import Constants.TEAK_PLANK
import Script
import homes.RequiredItems
import leafs.*
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class HasItems(script: Script) : Branch<Script>(script, "HasItems?") {
    override val successComponent: TreeComponent<Script> = IsFirstFloorDone(script)
    override val failedComponent: TreeComponent<Script> = BankOpened(script)

    private fun hasRequiredItems(): Boolean {
        val currentTier = script.contractTier
        val home = script.currentHome?.name
        if (!home.isNullOrEmpty()) {
            val itemsNeeded = RequiredItems.get(home, currentTier)

            val numberSteelBars = Inventory.stream().id(STEEL_BAR).toList().size
            script.logger.info(
                "Current steel bars: $numberSteelBars number of planks: ${
                    Inventory.stream().id(OAK_PLANK).toList().size
                }"
            )

            when (currentTier) {
                0 -> return ((Inventory.stream().id(PLANK).toList().size >= itemsNeeded!![0]) &&
                        (numberSteelBars >= itemsNeeded[1]))

                1 -> return ((Inventory.stream().id(OAK_PLANK).toList().size >= itemsNeeded!![0]) &&
                        (numberSteelBars >= itemsNeeded[1]))

                2 -> return ((Inventory.stream().id(TEAK_PLANK).toList().size >= itemsNeeded!![0]) &&
                        (numberSteelBars >= itemsNeeded[1]))

                3 -> return ((Inventory.stream().id(MAHOGANY_PLANK).toList().size >= itemsNeeded!![0]) &&
                        (numberSteelBars >= itemsNeeded[1]))
            }
        }
        return false
    }

    override fun validate(): Boolean {
        return hasRequiredItems()
    }
}
class BankOpened(script: Script) : Branch<Script>(script, "BankOpened") {
    override val successComponent: TreeComponent<Script> = ShouldWithdrawBars(script)
    override val failedComponent: TreeComponent<Script> = IsNearBank(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}

class IsNearBank(script: Script) : Branch<Script>(script, "IsNearBank") {
    override val successComponent: TreeComponent<Script> = Banking(script) //SimpleLeaf(script, "OpenBank") { if (!Bank.open()) Camera.angleToLocatable(Bank.nearest()) }
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.BANK)

    override fun validate(): Boolean {
        val bank = Bank.nearest()
        return bank.distance() < 10 && bank.tile().matrix().inViewport()
    }
}

class ShouldWithdrawBars(script: Script) : Branch<Script>(script, "ShouldWithdrawBars") {
    override val successComponent: TreeComponent<Script> = WithdrawBars(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawPlanks(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}

class ShouldWithdrawPlanks(script: Script) : Branch<Script>(script, "ShouldWithdrawPlanks") {
    override val successComponent: TreeComponent<Script> = WithdrawPlanks(script)
    override val failedComponent: TreeComponent<Script> = IsNearBank(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}