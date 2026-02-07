package org.jadamek.mealtpa.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TeleportManager {

    private static final HashMap<UUID, UUID> teleportRequests = new HashMap<>();

    public static void requestTeleport(Player from, Player to) {
        teleportRequests.put(to.getUniqueId(), from.getUniqueId());
    }

    public static boolean acceptTeleport(Player target) {
        UUID requesterId = teleportRequests.remove(target.getUniqueId());
        if (requesterId == null) return false;

        Player requester = Bukkit.getPlayer(requesterId);
        if (requester == null) return false;

        requester.teleport(target);
        requester.sendMessage("Teleported to  " + target.getName() + "!");
        target.sendMessage(requester.getName() + " Was teleported to u ");
        return true;
    }
}
