package com.coolv1994.noexplosions.listeners;

import com.coolv1994.noexplosions.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockIgniteEvent;

/**
 *
 * @author Vinnie
 */
public class FireListener implements Listener {
    private final Plugin plugin;

    public FireListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockIgnite(BlockIgniteEvent event) {
       if (plugin.getBlockedIgniters().contains(event.getCause())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBurn(BlockBurnEvent event) {
        if (plugin.getBlockFireDestrucion()) {
            event.setCancelled(true);
        }
    }

}
