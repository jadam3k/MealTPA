package org.jadamek.mealtpa.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MealShopListener  implements Listener {
    @EventHandler // wow something new
    public void onInventoryClick(InventoryClickEvent event) { //camel final boss
            if (!event.getView().getTitle().equals(ChatColor.DARK_AQUA + "mAgIcAL ToTeM sHoP")) return;

            event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();


        if (event.getSlot() != 13) return;
//HasEnoughDiamonds will be private for checking diamonds dont forget mannn


        if (!hasEnoughDiamonds(player)) {
            player.sendMessage(ChatColor.RED + "Bro get more diamonds");
            return;
        }

        removeDiamonds(player); //this will remove diamonds

        ItemStack teleportTotem = createTeleportTotem(); //that will create totem saving for later
        player.getInventory().addItem(teleportTotem);
        player.sendMessage(ChatColor.GREEN + "you made it broski");
        player.closeInventory();
    }

    private boolean hasEnoughDiamonds(Player player) {

                int diamondCount = 0;
                for (ItemStack item : player.getInventory().getContents()) {
                    if (item != null && item.getType() == Material.DIAMOND) {
                        diamondCount += item.getAmount();
                    }
                }
                return diamondCount >= 3;
    }

    private void removeDiamonds(Player player) {
            int diamondsRemoved = 0;
            for (int i = 0; i < player.getInventory().getSize(); i++) {
                ItemStack item = player.getInventory().getItem(i);
                if (item != null && item.getType() == Material.DIAMOND) {
                    //bro
                    if (item.getAmount() > 1) {
                        item.setAmount(item.getAmount() - 1);
                    } else {
                        player.getInventory().setItem(1, null);
                    }
                    diamondsRemoved++;

                    if (diamondsRemoved == 3 ) break; //leetcode final boss
                }

//im stupid
            }

    }
    private ItemStack createTeleportTotem() {
        ItemStack totem = new ItemStack(Material.ROTTEN_FLESH); // idk why it but ok
        ItemMeta meta = totem.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "teleportation totem");
        meta.setLore(Arrays.asList(
                ChatColor.GRAY + "Mystical totem allowing to teleport",
                ChatColor.YELLOW + "Use /mealtpa <user> to teleport"
        ));
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS); // I THINK
        totem.setItemMeta(meta);
        return totem;
    }

}
