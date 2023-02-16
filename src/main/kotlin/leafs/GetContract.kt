package leafs

import Constants.NEW_CONTRACT_TILE
import Constants.SELECT_CONTRACT_COMPONENT
import Constants.SELECT_CONTRACT_WIDGET
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf

class GetContract(script: Script) : Leaf<Script>(script, "GetContract") {
    override fun execute() {
        //TODO
        val widget = Widgets.widget(SELECT_CONTRACT_WIDGET).component(SELECT_CONTRACT_COMPONENT)
        if (NEW_CONTRACT_TILE.distance() > 10 || !NEW_CONTRACT_TILE.reachable()) {
            Movement.walkTo(NEW_CONTRACT_TILE)
        } else {
            if (Chat.chatting() || widget.visible()) {
                script.logger.info("WIDGET VISIBLE")
                if (widget.component(script.contractTier + 1).click()) {
                    Condition.wait { !widget.visible() }
                }
            } else {
                script.logger.info("Not chatting")
                if (Npcs.stream().name("Amy").firstOrNull()?.interact("Contract") == true)
                    Condition.wait { widget.visible() || Chat.chatting() }
            }
            if (Chat.canContinue()) Chat.completeChat()
        }
    }
}
