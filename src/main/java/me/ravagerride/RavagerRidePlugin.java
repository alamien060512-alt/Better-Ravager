package me.ravagerride;

import org.bukkit.entity.Player;
import org.bukkit.entity.Ravager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RavagerRidePlugin extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("BetterRavager enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("BetterRavager disabled!");
    }

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {

        if (!(event.getRightClicked() instanceof Ravager ravager)) {
            return;
        }

        Player player = event.getPlayer();

        if (player.isInsideVehicle()) {
            return;
        }

        event.setCancelled(true);
        ravager.addPassenger(player);
    }
}
