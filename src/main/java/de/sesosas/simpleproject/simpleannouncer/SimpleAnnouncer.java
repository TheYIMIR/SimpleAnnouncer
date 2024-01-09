package de.sesosas.simpleproject.simpleannouncer;

import de.sesosas.simpleproject.simpleannouncer.classes.AnnouncementHandler;
import de.sesosas.simpleproject.simpleannouncer.helper.AnnouncementObjectLoader;
import de.sesosas.simpleproject.simpleannouncer.helper.UpdateHandler;
import de.sesosas.simpleproject.simpleannouncer.objects.AnnouncementObject;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.SingleLineChart;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class SimpleAnnouncer extends JavaPlugin {

    public static SimpleAnnouncer plugin;
    public static SimpleAnnouncer getPlugin(){
        return plugin;
    }
    public static AnnouncementHandler announcementHandler;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        plugin = this;

        java.lang.String[] listexample = new java.lang.String[]{"This is another Test", "Line 2"};
        config.addDefault("Announcements.Test.Enabled", true);
        config.addDefault("Announcements.Test.Time", 5);
        config.addDefault("Announcements.Test.Message", "This is a Test.");
        config.addDefault("Announcements.AnotherTest.Enabled", true);
        config.addDefault("Announcements.AnotherTest.Time", 3);
        config.addDefault("Announcements.AnotherTest.Message", listexample);
        config.addDefault("Chat.Prefix", "§f[§cSimpleAnnouncer§f]");
        config.addDefault("bstats.Enable", true);
        config.options().copyDefaults(true);
        saveConfig();

        if(config.getBoolean("bstats.Enable")){
            int id = 20702;
            Metrics metrics = new Metrics(this, id);
        }

        /*
        new UpdateHandler(this, 101989).getVersion(version -> {
            if (Float.parseFloat(this.getDescription().getVersion()) < Float.parseFloat(version)) {
                getLogger().info("There is a new update available.");
            } else {
                getLogger().info("There is no a new update available.");
            }
        });
        */

        announcementHandler = new AnnouncementHandler(AnnouncementObjectLoader.LoadAnnouncementObjects());
        announcementHandler.ExecuteAnnouncements();
    }
}
