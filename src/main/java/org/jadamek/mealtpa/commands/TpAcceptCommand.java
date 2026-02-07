package org.jadamek.mealtpa.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jadamek.mealtpa.utils.TeleportManager;

public class TpAcceptCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Bro who are you" );
            return true;
        }


        Player player = (Player) sender;

        if (TeleportManager.acceptTeleport(player)) {
            player.sendMessage(ChatColor.GREEN + "Teleportation ACCEPTED");
        } else {
            player.sendMessage(ChatColor.GREEN + "Nobody wants to tp to you bro");
        }

        return true;
    }
}
