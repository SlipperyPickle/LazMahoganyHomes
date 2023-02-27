package leafs

import Constants.PLANK_SACK
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class EmptyPlankSack(script: Script) : Leaf<Script>(script, "OpenBank") {
    override fun execute() {
        val invCount = Inventory.occupiedSlotCount()
        val plankSack = Inventory.stream().id(PLANK_SACK).first()
        if (plankSack.valid() && plankSack.interact("Empty")) {
            Condition.wait { Inventory.occupiedSlotCount() != invCount }
        }
    }
}


