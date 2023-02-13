package branch

import Constants.MAHOGANY_PLANK
import Constants.OAK_PLANK
import Constants.PLANK
import Constants.STEEL_BAR
import Constants.TEAK_PLANK
import Script
import homes.Homes
import homes.RequiredItems
import leafs.Banking
import leafs.Dummy
import leafs.GetContract
import leafs.ExecuteContract
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.SimpleLeaf
import org.powbot.api.script.tree.TreeComponent
import kotlin.math.log

class ShouldGetContract(script: Script) : Branch<Script>(script, "ShouldGetContract") {
    override val successComponent: TreeComponent<Script> = GetContract(script)
    override val failedComponent: TreeComponent<Script> = ShouldExecuteContract(script)

    override fun validate(): Boolean {
        return script.currentHome == null
    }
}

class ShouldExecuteContract(script: Script) : Branch<Script>(script, "ShouldExecuteContract") {
    override val successComponent: TreeComponent<Script> = ExecuteContract(script)
    override val failedComponent: TreeComponent<Script> = Dummy(script)  //Banking(script) // SimpleLeaf(script, "SimpleLeaf") { }

    private fun hasRequiredItems(): Boolean {
        val currentTier = script.contractTier
        val home = script.currentHome?.name
        if (!home.isNullOrEmpty()) {
            val itemsNeeded = RequiredItems.get(home, currentTier)
            script.logger.info("Items needed: ${itemsNeeded.contentToString()}")
            val numberSteelBars = Inventory.stream().id(STEEL_BAR).toList().size
            script.logger.info("Current steel bars: $numberSteelBars number of planks: ${Inventory.stream().id(OAK_PLANK).toList().size}")

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
        script.logger.info("hasRequiredItems(): ${hasRequiredItems()}")
//        return false
        return hasRequiredItems()
    }
}