package com.coolv1994.noexplosions.listeners;

import com.coolv1994.noexplosions.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.PortalCreateEvent;

/**
 *
 * @author Vinnie
 */
public class PortalListener implements Listener {
    private final Plugin plugin;

    public PortalListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPortalCreation(PortalCreateEvent event) {
       if (plugin.getBlockedPortals().contains(event.getReason())) {
            event.setCancelled(true);
        }
    }

}
