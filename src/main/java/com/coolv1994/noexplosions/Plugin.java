package com.coolv1994.noexplosions;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Vinnie
 */
public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        getServer().getPluginManager().registerEvents(new ExplosionListener(this), this);
    }

    @Override
    public void onDisable() {
        // nothing
    }

}
