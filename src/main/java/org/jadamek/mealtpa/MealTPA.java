package org.jadamek.mealtpa;

import org.bukkit.plugin.java.JavaPlugin;
import org.jadamek.mealtpa.commands.MealBotCommand;
import org.jadamek.mealtpa.commands.MealShopCommand;
import org.jadamek.mealtpa.commands.MealtpaCommand;
import org.jadamek.mealtpa.commands.TpAcceptCommand;
import org.jadamek.mealtpa.listeners.MealBotListener;
import org.jadamek.mealtpa.listeners.MealShopListener;

public final class MealTPA extends JavaPlugin {

    private static MealTPA instance;

    @Override
    public void onEnable() {
        instance = this;

        // Rejestracja komendy
        this.getCommand("mealtpa").setExecutor(new MealtpaCommand());
        this.getCommand("tpaccept").setExecutor(new TpAcceptCommand());
        this.getCommand("mealshop").setExecutor(new MealShopCommand());
        getCommand("mealbot").setExecutor(new MealBotCommand());
        getServer().getPluginManager().registerEvents(new MealBotListener(), this);

        getServer().getPluginManager().registerEvents(new MealShopListener(), this);

        getLogger().info("MealTPA is ON!");
    }

    @Override
    public void onDisable() {
        getLogger().info("MealTPA is OFF!");
    } //Lol it works

    public static MealTPA getInstance() {
        return instance;
    }
}
