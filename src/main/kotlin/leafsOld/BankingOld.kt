package leafsOld

import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Camera
import org.powbot.api.script.tree.Leaf

class BankingOld(script: Script) : Leaf<Script>(script, "Banking") {
    override fun execute() {
        if(Bank.inViewport() && Bank.open()) {
            Condition.wait { Bank.opened() }
        } else {
            Camera.turnTo(Bank.nearest().tile())
        }
    }
}


