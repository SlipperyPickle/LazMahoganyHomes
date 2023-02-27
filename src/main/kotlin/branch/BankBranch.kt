package branch

import Constants.AMYS_SAW
import Constants.HAMMER
import Constants.SAW
import Constants.STEEL_BAR
import Script
import homes.Homes
import leafs.OpenBank
import leafs.Destination
import leafs.WalkTo
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.SimpleLeaf
import org.powbot.api.script.tree.TreeComponent

class HasAllItems(script: Script) : Branch<Script>(script, "HasAllItems") {
    override val successComponent: TreeComponent<Script> = SimpleLeaf(script, "true") {}
    override val failedComponent: TreeComponent<Script> = BankOpened(script)

    private fun hasItems(): Boolean {
        val home = script.currentHome!!
        val reqItems = home.getRequiredItems(home.home, script.currentTier)

        val hasHammer = Inventory.stream().id(HAMMER).isNotEmpty()
        val hasSaw = Inventory.stream().id(*intArrayOf(SAW, AMYS_SAW)).isNotEmpty()
        val hasPlanks = (Inventory.stream().id(home.getPlank(script.currentTier)).count() + script.plankSackNumber - reqItems[0]) > 0
        val hasBars = (Inventory.stream().id(STEEL_BAR)).count() >= script.steelBars

        script.logger("hasItems", "Hammer = $hasHammer Saw = $hasSaw Planks = $hasPlanks Bars = $hasBars")
        return (hasHammer && hasSaw && hasPlanks && hasBars)
    }

    override fun validate(): Boolean {
        return hasItems() && !Homes.inCurrentHome(script.currentHome!!.name)
    }
}

class BankOpened(script: Script) : Branch<Script>(script, "BankOpened") {
    override val successComponent: TreeComponent<Script> = ShouldWithdrawSaw(script)
    override val failedComponent: TreeComponent<Script> = IsNearBank(script)

    override fun validate(): Boolean {
        return Bank.opened()
    }
}

class IsNearBank(script: Script) : Branch<Script>(script, "IsNearBank") {
    override val successComponent: TreeComponent<Script> = OpenBank(script)
    override val failedComponent: TreeComponent<Script> = WalkTo(script, Destination.BANK)

    override fun validate(): Boolean {
        val bank = Bank.nearest()
        return (bank.distance() < 10 && bank.tile().matrix().inViewport())
    }
}

class ShouldWithdrawSaw(script: Script) : Branch<Script>(script, "ShouldWithdrawSaw") {
    override val successComponent: TreeComponent<Script> = WithdrawSaw(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawHammer(script)

    override fun validate(): Boolean {
        return Inventory.stream().id(*intArrayOf(SAW, AMYS_SAW)).isEmpty()
    }
}

class ShouldWithdrawHammer(script: Script) : Branch<Script>(script, "ShouldWithdrawHammer") {
    override val successComponent: TreeComponent<Script> = WithdrawHammer(script)
    override val failedComponent: TreeComponent<Script> = ShouldWithdrawBars(script)

    override fun validate(): Boolean {
        return Inventory.stream().id(HAMMER).isEmpty()
    }
}

class ShouldWithdrawBars(script: Script) : Branch<Script>(script, "ShouldWithdrawBars") {
    override val successComponent: TreeComponent<Script> = WithdrawBars(script)
    override val failedComponent: TreeComponent<Script> = WithdrawPlanks(script)

    override fun validate(): Boolean {
        return script.steelBars - Inventory.stream().id(STEEL_BAR).count().toInt() > 0
    }
}

//class ShouldFillPlankSack(script: Script) : Branch<Script>(script, "ShouldWithdrawBars") {
//    override val successComponent: TreeComponent<Script> = FillPlankSack(script)
//    override val failedComponent: TreeComponent<Script> = WithdrawPlanks(script)
//
//    override fun validate(): Boolean {
//        return
//    }
//}