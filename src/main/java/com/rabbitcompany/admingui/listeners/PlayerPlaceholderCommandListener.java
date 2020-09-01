package com.rabbitcompany.admingui.listeners;

import com.rabbitcompany.admingui.AdminGUI;
import com.rabbitcompany.admingui.ui.AdminUI;
import com.rabbitcompany.admingui.utils.Message;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerPlaceholderCommandListener implements Listener {

    private AdminGUI adminGUI;

    public PlayerPlaceholderCommandListener(AdminGUI plugin){
        adminGUI = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event){
        Player p = event.getPlayer();
        String message = event.getMessage();
        String chat_command_spy_format = PlaceholderAPI.setPlaceholders(p, adminGUI.getConf().getString("acs_format"));

        if(AdminUI.freeze.getOrDefault(p.getUniqueId(), false) && AdminGUI.getInstance().getConf().getBoolean("freeze_execute_commands", true)){
            event.setCancelled(true);
            return;
        }

        if(adminGUI.getConf().getBoolean("acs_enabled")){
            for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                if(player.hasPermission("admingui.chat.spy") && AdminUI.command_spy.getOrDefault(player.getUniqueId(), false) && !player.getUniqueId().equals(p.getUniqueId())){
                    player.sendMessage(Message.chat(chat_command_spy_format.replace("{name}", p.getName()).replace("{display_name}", p.getDisplayName()).replace("{message}", message)));
                }
            }
        }
    }

}
