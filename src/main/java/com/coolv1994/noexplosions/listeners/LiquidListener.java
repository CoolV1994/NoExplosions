package com.coolv1994.noexplosions.listeners;

import com.coolv1994.noexplosions.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

/**
 *
 * @author Vinnie
 */
public class LiquidListener implements Listener {
    private final Plugin plugin;

    public LiquidListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        if (plugin.getBlockedLiquidFlow().contains(event.getBlock().getType())) {
            event.setCancelled(true);
        }
    }

}
