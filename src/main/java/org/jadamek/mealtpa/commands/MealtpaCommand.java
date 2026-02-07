package org.jadamek.mealtpa.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jadamek.mealtpa.utils.TeleportManager;

import java.util.Arrays;
import java.util.Objects;

public class MealtpaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Bro who are you" );
            return true;

        }

        Player player = (Player) sender;

        if (!hasTeleportTotem(player)) {
            player.sendMessage(ChatColor.RED + "Bro wanted to tp wihout totem");
            return true;
        }

        if (args.length != 1 ) {
            player.sendMessage(ChatColor.RED + "Usage: /mealtpa <player>");
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            player.sendMessage((ChatColor.RED + "Player is not online"));
            return true;
        }

        if (target.equals(player)) {
            player.sendMessage(ChatColor.RED + "You can't teleport to yourself gng");
            return true;
        }

        TeleportManager.requestTeleport(player, target);
        player.sendMessage(ChatColor.GREEN + "You sent idk how to say that in english. but you sent oh i know REQUEST to player to get teleported ;)");
        target.sendMessage((ChatColor.YELLOW + player.getName() + "Want to teleport to you babe"));

        return true;


    }
    private boolean hasTeleportTotem(Player player) {
        return Arrays.stream(player.getInventory().getContents())
                .filter(Objects::nonNull) // first time using it wtf is this
                .anyMatch(item ->
                        item.getType() == Material.ROTTEN_FLESH && item.getItemMeta().getDisplayName().contains("Test teleportation totem"));
    }
}
