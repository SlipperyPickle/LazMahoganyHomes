package leafs

import Script
import homes.Data
import org.powbot.api.rt4.Objects
import org.powbot.api.script.tree.Leaf

class Dummy(script: Script) : Leaf<Script>(script, "Banking") {
    override fun execute() {
        script.logger.info("Count = ${Data.count()}")
        val stair = Objects.stream().id(40067).nearest().first()

//        stair.m
//        Objects.stream().mi
    }
}


