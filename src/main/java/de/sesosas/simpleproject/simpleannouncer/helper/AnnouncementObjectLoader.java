package de.sesosas.simpleproject.simpleannouncer.helper;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;
import de.sesosas.simpleproject.simpleannouncer.objects.AnnouncementObject;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;

public class AnnouncementObjectLoader {
    public static List<AnnouncementObject> LoadAnnouncementObjects(){
        ConfigurationSection announcementsSection = SimpleAnnouncer.getPlugin().config.getConfigurationSection("Announcements");
        Set<String> announcementKeys = announcementsSection.getKeys(false);

        List<AnnouncementObject> announcementObjectList = new ArrayList<>();

        for (String key : announcementKeys) {
            ConfigurationSection announcementSection = announcementsSection.getConfigurationSection(key);

            String section = key;
            boolean enabled = announcementSection.getBoolean("Enabled");
            long time = announcementSection.getLong("Time");

            Object messageObject = announcementSection.get("Message");
            List<String> messages;

            if (messageObject instanceof String) {
                messages = Collections.singletonList((String) messageObject);
            } else if (messageObject instanceof List) {
                messages = (List<String>) messageObject;
            } else if (messageObject instanceof String[]) {
                messages = Arrays.asList((String[]) messageObject);
            } else {
                messages = Collections.emptyList();
                Bukkit.getLogger().warning("Unknown message type: '" + key + "'. Only strings and lists are allowed.");
            }

            AnnouncementObject announcementObject = new AnnouncementObject(section, enabled, messages, time);
            announcementObjectList.add(announcementObject);
        }

        return announcementObjectList;
    }
}
