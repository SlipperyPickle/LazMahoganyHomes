package leafs

import Constants.CONTRACT_ADEPT
import Constants.CONTRACT_BEGINNER
import Constants.CONTRACT_EXPERT
import Constants.CONTRACT_FINISH
import Constants.CONTRACT_NOVICE
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class TalkToHomeOwner(script: Script) : Leaf<Script>(script, "TalkToHomeOwner") {
    override fun execute() {
        if (Chat.chatting()) {
            Chat.completeChat(CONTRACT_FINISH)
        } else {
            val homeOwner = Npcs.stream().name(script.currentHome!!.home).first()
            if (homeOwner.valid() && homeOwner.inViewport() && homeOwner.interact("Talk-to")) {
                Condition.wait({ Chat.chatting() }, 75, 30)
            } else {
                Notifications.showNotification("Couldn't find ${homeOwner.name}, stopping")
                script.logger("TalkToHomeOwner", "Couldn't find ${homeOwner.name}, stopping")
                ScriptManager.stop()
            }
        }
    }
}


