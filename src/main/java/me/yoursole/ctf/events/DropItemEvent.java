package me.yoursole.ctf.events;

import me.yoursole.ctf.data.items.Flag;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropItemEvent implements Listener {
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().isSimilar(Flag.flag)) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "You can not get rid of this");
        }

    }
}
