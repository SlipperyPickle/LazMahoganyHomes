package leafs

import Constants.SELECT_CONTRACT_COMPONENT
import Constants.SELECT_CONTRACT_WIDGET
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Chat
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf

class GetContract(script: Script) : Leaf<Script>(script, "GetContract") {
    override fun execute() {
        //TODO
        val widget = Widgets.widget(SELECT_CONTRACT_WIDGET).component(SELECT_CONTRACT_COMPONENT)

        if (widget.visible()) {
//        if (Chat.chatting() || widget.visible()) {
            if (widget.component(script.contractTier + 1).click()) {
                Condition.wait { !widget.visible() }
            }
        } else {
            if (Npcs.stream().name("Amy").firstOrNull()?.interact("Contract") == true)
                Condition.wait { widget.visible() || Chat.chatting() }
        }
        Chat.completeChat()
    }

}
