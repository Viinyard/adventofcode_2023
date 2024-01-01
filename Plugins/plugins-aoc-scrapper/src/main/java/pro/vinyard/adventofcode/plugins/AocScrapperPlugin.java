package pro.vinyard.adventofcode.plugins;

import pro.vinyard.plugins.api.PluginContext;
import pro.vinyard.plugins.api.VelocityBlueprintPlugin;

public class AocScrapperPlugin extends VelocityBlueprintPlugin {

    public AocScrapperPlugin(PluginContext context) {
        super(context);
    }

    @Override
    public void start() {
        log.trace("AocScrapperPlugin.start()");
    }

    @Override
    public void stop() {
        log.trace("AocScrapperPlugin.stop()");
    }

    @Override
    public void delete() {
        log.trace("AocScrapperPlugin.delete()");
    }
}
