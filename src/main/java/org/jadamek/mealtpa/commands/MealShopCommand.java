package org.jadamek.mealtpa.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MealShopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Dawg i told you you have to be human");
            return true;
        }

        Player player = (Player) sender;
        Inventory shopInventory = Bukkit.createInventory(null, 27, ChatColor.DARK_AQUA + "mAgIcAL ToTeM sHoP");


        ItemStack diamondBlock = new
                ItemStack(Material.DIAMOND_BLOCK);
        ItemMeta blockMeta = diamondBlock.getItemMeta();
        blockMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Create Teleportation Totem");
        blockMeta.setLore(Arrays.asList(
                ChatColor.GRAY + "Requires 3 diamonds to make",
                ChatColor.MAGIC + "CLICK TO MAKE"
        ));
        diamondBlock.setItemMeta(blockMeta);

        shopInventory.setItem(13, diamondBlock);
        player.openInventory(shopInventory);
        return true;
    }
}
