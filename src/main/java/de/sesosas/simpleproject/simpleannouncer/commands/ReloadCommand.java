package de.sesosas.simpleproject.simpleannouncer.commands;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;
import de.sesosas.simpleproject.simpleannouncer.classes.AnnouncementHandler;
import de.sesosas.simpleproject.simpleannouncer.helper.AnnouncementObjectLoader;
import de.sesosas.simpleproject.simpleannouncer.helper.MessageHandler;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            File file = new File(SimpleAnnouncer.getPlugin().getDataFolder().getAbsolutePath() + "/config.yml");
            FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
            SimpleAnnouncer.getPlugin().config = cfg;
            SimpleAnnouncer.announcementHandler.StopAnnouncements();
            SimpleAnnouncer.announcementHandler = new AnnouncementHandler(AnnouncementObjectLoader.LoadAnnouncementObjects());
            SimpleAnnouncer.announcementHandler.ExecuteAnnouncements();

            String text = "Successfully reloaded the Config!";
            MessageHandler.Send(player, ChatColor.AQUA + text);
        }
        return false;
    }
}
