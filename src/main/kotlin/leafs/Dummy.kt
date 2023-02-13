package leafs

import Constants.OAK_PLANK
import Constants.PORTAL
import Constants.STEEL_BAR
import Script
import homes.Data
import homes.RequiredItems
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager
import java.util.*

class Dummy(script: Script) : Leaf<Script>(script, "Banking") {
    override fun execute() {
        script.logger.info("Count = ${Data.objectsLeft()}")
    }
}


