package leafs

import Constants.BUILD_FURNITURE_COMPONENT
import Constants.BUILD_FURNITURE_WIDGET
import Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Widgets
import org.powbot.api.script.tree.Leaf

class BuildWidget(script: Script) : Leaf<Script>(script, "BuildWidget") {
    override fun execute() {
        val buildWidget =
            Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.currentTier)

        if (buildWidget.interact("Build")) {
            Condition.wait {
                !Widgets.widget(BUILD_FURNITURE_WIDGET).component(BUILD_FURNITURE_COMPONENT + script.currentTier)
                    .visible()
            }
        }
    }
}



