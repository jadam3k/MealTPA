package org.jadamek.mealtpa.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MealBotCommand implements CommandExecutor, Listener {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args ) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Dawg i told you you have to be human");
            return true;
        }

        Player player = (Player) sender;

        if (!player.isOp()) {
            player.sendMessage(ChatColor.RED + "You have to be server Operator");
            return true;
        }

        Location loc = player.getLocation();

        Zombie zombie = player.getWorld().spawn(loc, Zombie.class);
        zombie.setVillager(true);
        zombie.setCustomName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Unknown Seller");
        zombie.setCustomNameVisible(true);

        zombie.setCanPickupItems(false);
        zombie.setTarget(null); //no PVP

        zombie.addPotionEffect(new PotionEffect(
                PotionEffectType.SLOW,
                Integer.MAX_VALUE,
                10,
                false,
                false
        ));

        zombie.addPotionEffect(new PotionEffect(
                PotionEffectType.JUMP,
                Integer.MAX_VALUE,
                128,
                false,
                false // idk it will work loll
        ));

        player.sendMessage(ChatColor.GOLD + "Unknown Seller RISEN!!!");
        return true;




    }
}
