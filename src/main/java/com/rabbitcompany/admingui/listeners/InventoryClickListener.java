package com.rabbitcompany.admingui.listeners;

import com.rabbitcompany.admingui.AdminGUI;
import com.rabbitcompany.admingui.ui.AdminUI;
import com.rabbitcompany.admingui.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private AdminGUI adminGUI;
    private AdminUI adminUI = new AdminUI();

    public InventoryClickListener(AdminGUI plugin){
        adminGUI = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){
        String title = e.getView().getTitle();
        String player = e.getWhoClicked().getName();
        Player p = (Player) e.getWhoClicked();

        try{
                if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_main")) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_player").replace("{player}", player)) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_world")) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_players")) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_plugins")) || title.contains(Message.getMessage(p.getUniqueId(), "inventory_commands")) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_unban")) || title.equals(Message.getMessage(p.getUniqueId(), "players_color").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_actions").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_kick").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_ban").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_potions").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_spawner").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_inventory").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_give").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_set").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_take").replace("{player}", AdminUI.target_player.get(p).getName())) || title.equals(Message.getMessage(p.getUniqueId(), "inventory_money").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                    e.setCancelled(true);

                    if(e.getClickedInventory().equals(e.getView().getTopInventory())) {

                        if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_main"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_main(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_player").replace("{player}", player))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_player(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_world"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_world(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_players"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_players(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_plugins"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_plugins(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.contains(Message.getMessage(p.getUniqueId(), "inventory_commands"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_commands(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_unban"))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_unban_players(p, e.getSlot(), e.getCurrentItem(), e.getInventory());
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "players_color").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_players_settings(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_actions").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_actions(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }

                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_kick").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_kick(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_ban").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_ban(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_potions").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_potions(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_spawner").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_spawner(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_money").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_money(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p));
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_give").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_money_amount(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p), 1);
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_set").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_money_amount(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p), 2);
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_money_take").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                adminUI.clicked_money_amount(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p), 3);
                            }
                        } else if (title.equals(Message.getMessage(p.getUniqueId(), "inventory_inventory").replace("{player}", AdminUI.target_player.get(p).getName()))) {

                            if (e.getCurrentItem() != null) {
                                if (e.isLeftClick()) {
                                    adminUI.clicked_inventory(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p), true);
                                } else {
                                    adminUI.clicked_inventory(p, e.getSlot(), e.getCurrentItem(), e.getInventory(), AdminUI.target_player.get(p), false);
                                }
                            }
                        }
                }
            }
        }catch (Exception i){
            Bukkit.getConsoleSender().sendMessage(i.getMessage());
        }
    }
}
