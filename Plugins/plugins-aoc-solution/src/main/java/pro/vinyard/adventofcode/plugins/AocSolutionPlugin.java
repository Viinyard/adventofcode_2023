package pro.vinyard.adventofcode.plugins;

import pro.vinyard.plugins.api.PluginContext;
import pro.vinyard.plugins.api.VelocityBlueprintPlugin;

public class AocSolutionPlugin extends VelocityBlueprintPlugin {
    public AocSolutionPlugin(PluginContext context) {
        super(context);
    }

    @Override
    public void start() {
        log.trace("AocSolutionPlugin.start()");
    }

    @Override
    public void stop() {
        log.trace("AocSolutionPlugin.stop()");
    }

    @Override
    public void delete() {
        log.trace("AocSolutionPlugin.delete()");
    }
}
