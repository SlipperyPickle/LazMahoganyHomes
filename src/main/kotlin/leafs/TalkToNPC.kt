package leafs

import Constants.CONTRACT_FINISH
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf

class TalkToNPC(script: Script) : Leaf<Script>(script, "TalkTo") { //${script.currentHome!!.home}") {

    override fun execute() {
        val homeOwner = Npcs.stream().name(script.currentHome!!.home).first()
        if (Chat.completeChat(CONTRACT_FINISH)) {
            Condition.wait { !Chat.chatting() }
        } else if (homeOwner.valid() && homeOwner.inViewport() && homeOwner.interact("Talk-to")) {
            Condition.wait({ Chat.chatting() }, 450, 10)
        }
    }
}