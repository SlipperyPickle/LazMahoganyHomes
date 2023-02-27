package leafs

import Constants.CONTRACT_ADEPT
import Constants.CONTRACT_BEGINNER
import Constants.CONTRACT_EXPERT
import Constants.CONTRACT_NOVICE
import Script
import org.powbot.api.Condition
import org.powbot.api.Notifications
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Npcs
import org.powbot.api.script.tree.Leaf
import org.powbot.mobile.script.ScriptManager

class TalkToAmy(script: Script) : Leaf<Script>(script, "TalkToAmy") {
    override fun execute() {
        if (Chat.chatting()) {
            val text = when (script.currentTier) {
                0 -> CONTRACT_BEGINNER
                1 -> CONTRACT_NOVICE
                2 -> CONTRACT_ADEPT
                3 -> CONTRACT_EXPERT
                else -> ""
            }
            Chat.completeChat(text)
            Condition.wait ({!Chat.chatting()}, 75, 20)
        } else {
            val amy = Npcs.stream().name("Amy").nearest().first()
            if (!amy.valid()) {
                Notifications.showNotification("Couldn't find Amy, stopping")
                script.logger("WithdrawSaw", "Couldn't find Amy, stopping")
                ScriptManager.stop()
            }
            if (!amy.inViewport()) {
                Camera.turnTo(amy)
            } else {
                if (amy.interact("Contract")) {
                    Condition.wait ({Chat.chatting()}, 75, 20)
                }
            }
        }
    }
}


