package leafs

import Constants.CONTRACT_FINISH
import Constants.PLANK_SACK
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Inventory
import org.powbot.api.script.tree.Leaf

class CheckPlankSack(script: Script) : Leaf<Script>(script, "FillPlankSack") {
    override fun execute() {
       val plankSack = Inventory.stream().id(PLANK_SACK).first()
       if (plankSack.valid() && plankSack.interact("Check")) {
          Condition.wait { script.plankSackNumber != -1 }
       }
    }
}


