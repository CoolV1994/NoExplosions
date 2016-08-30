package com.coolv1994.noexplosions.commands;

import com.coolv1994.noexplosions.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 *
 * @author Vinnie
 */
public class NoExplosionCommand implements CommandExecutor {
    private final Plugin plugin;

    public NoExplosionCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("noexplosions.reload")) {
                plugin.reloadConfig();
                plugin.reloadProtections();
                sender.sendMessage(ChatColor.GREEN + "NoExplosions configuration reloaded.");
            } else {
                sender.sendMessage(ChatColor.RED + "You do not have permission to do this.");
            }
            return true;
        }

        sender.sendMessage("NoExplosions by CoolV1994. Version: " + plugin.getDescription().getVersion());
        return true;
    }

}
