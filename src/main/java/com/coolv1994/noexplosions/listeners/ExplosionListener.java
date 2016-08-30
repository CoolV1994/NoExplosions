package com.coolv1994.noexplosions.listeners;

import com.coolv1994.noexplosions.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

/**
 *
 * @author Vinnie
 */
public class ExplosionListener implements Listener {
    private final Plugin plugin;

    public ExplosionListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event) {
        if (plugin.getBlockedEntities().contains(event.getEntityType())) {
            event.setCancelled(true);
        }
    }

}
