package de.sesosas.simpleproject.simpleannouncer.helper;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class MessageHandler {
    public static void Send(Player player, String text){
        String prefix = CurrentConfig.getString("Chat.Prefix");
        if(CurrentConfig.getBoolean("Chat.ActionbarMessage")){
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(prefix + " " + StringFormater.Get(text, player)));
        }
        else{
            player.sendMessage(prefix + " " + StringFormater.Get(text, player));
        }
    }
}
