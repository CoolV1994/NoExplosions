package com.coolv1994.noexplosions;

import java.util.EnumSet;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExplosionPrimeEvent;

/**
 *
 * @author Vinnie
 */
public class ExplosionListener implements Listener {
    private final EnumSet<EntityType> blockedEntities;

    public ExplosionListener(Plugin plugin) {
        blockedEntities = EnumSet.noneOf(EntityType.class);
        for (String entity : plugin.getConfig().getStringList("blockedEntities")) {
            blockedEntities.add(EntityType.valueOf(entity));
        }
    }

    @EventHandler
    public void onExplosion(ExplosionPrimeEvent event) {
        if (blockedEntities.contains(event.getEntityType())) {
            event.setCancelled(true);
        }
    }

}
