package leafs

import Constants.CONTRACT_FINISH
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf

class TalkToHomeOwner(script: Script) : Leaf<Script>(script, "TalkToHomeOwner") {
    override fun execute() {
        if (Chat.chatting()) {
            Chat.completeChat(CONTRACT_FINISH)
        } else {
            var homeOwner = Npcs.stream().name(script.currentHome!!.home).first()
            if (!homeOwner.valid()) {
                homeOwner = Npcs.stream().id(script.currentHome!!.npcID).first()
            }
            if (homeOwner.interact("Talk-to")) {
                Condition.wait({ Chat.chatting() }, 75, 30)
            }
        }
    }
}


