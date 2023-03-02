package leafs

import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Camera
import org.powbot.api.script.tree.Leaf

class OpenBank(script: Script) : Leaf<Script>(script, "OpenBank") {
    override fun execute() {
        if(Bank.open()) {
            Condition.wait { Bank.opened() }
        }
    }
}


