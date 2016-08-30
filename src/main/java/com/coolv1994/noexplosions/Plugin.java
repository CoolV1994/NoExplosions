package com.coolv1994.noexplosions;

import com.coolv1994.noexplosions.commands.*;
import com.coolv1994.noexplosions.listeners.*;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.world.PortalCreateEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.EnumSet;

/**
 *
 * @author Vinnie
 */
public class Plugin extends JavaPlugin {
    private EnumSet<EntityType> blockedEntities;
    private EnumSet<BlockIgniteEvent.IgniteCause> blockedIgniters;
    private EnumSet<Material> blockedLiquidFlow;
    private EnumSet<PortalCreateEvent.CreateReason> blockedPortals;
    private boolean blockFireDestrucion;

    public EnumSet<EntityType> getBlockedEntities() {
        return blockedEntities;
    }

    public EnumSet<BlockIgniteEvent.IgniteCause> getBlockedIgniters() {
        return blockedIgniters;
    }

    public EnumSet<Material> getBlockedLiquidFlow() {
        return blockedLiquidFlow;
    }

    public EnumSet<PortalCreateEvent.CreateReason> getBlockedPortals() {
        return blockedPortals;
    }

    public boolean getBlockFireDestrucion() {
        return blockFireDestrucion;
    }

    public void reloadProtections() {
        blockedEntities = EnumSet.noneOf(EntityType.class);
        for (String entity : getConfig().getStringList("blockedEntities")) {
            blockedEntities.add(EntityType.valueOf(entity));
        }

        blockedIgniters = EnumSet.noneOf(BlockIgniteEvent.IgniteCause.class);
        for (String entity : getConfig().getStringList("blockedIgniters")) {
            blockedIgniters.add(BlockIgniteEvent.IgniteCause.valueOf(entity));
        }

        blockedLiquidFlow = EnumSet.noneOf(Material.class);
        for (String entity : getConfig().getStringList("blockedLiquidFlow")) {
            blockedLiquidFlow.add(Material.valueOf(entity));
        }

        blockedPortals = EnumSet.noneOf(PortalCreateEvent.CreateReason.class);
        for (String entity : getConfig().getStringList("blockedPortals")) {
            blockedPortals.add(PortalCreateEvent.CreateReason.valueOf(entity));
        }

        blockFireDestrucion = getConfig().getBoolean("blockFireDestrucion");
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        reloadConfig();
        reloadProtections();
        getCommand("noexplosions").setExecutor(new NoExplosionCommand(this));
        getServer().getPluginManager().registerEvents(new ExplosionListener(this), this);
        getServer().getPluginManager().registerEvents(new FireListener(this), this);
        getServer().getPluginManager().registerEvents(new LiquidListener(this), this);
        getServer().getPluginManager().registerEvents(new PortalListener(this), this);
    }

    @Override
    public void onDisable() {
        // nothing
    }

}
