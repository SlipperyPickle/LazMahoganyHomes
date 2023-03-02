package leafs

import Script
import org.powbot.api.Tile
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class Dummy(script: Script) : Leaf<Script>(script, "Dummy") {
    override fun execute() {
        Movement.moveTo(Tile(3242, 3489, 1))
    }
}