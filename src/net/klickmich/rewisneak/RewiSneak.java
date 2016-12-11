package net.klickmich.rewisneak;

import net.klickmich.rewisneak.util.Hologram;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class RewiSneak extends JavaPlugin implements Listener {

    private static RewiSneak instance;
    private Hologram hologram;

    public void onEnable() {
        this.instance = this;
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.isSneaking()) {
            new Hologram(player.getLocation(), "Willkommen auf Klickmich.net", (double) 10);
            hologram.spawn();
        } else {
            if (hologram.ifHologram()) {
                hologram.remove();
            }
        }
    }

    public static RewiSneak getInstance() {
        return instance;
    }
}
