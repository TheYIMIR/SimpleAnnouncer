package de.sesosas.simpleproject.simpleannouncer.classes;

import de.sesosas.simpleproject.simpleannouncer.SimpleAnnouncer;
import org.bukkit.util.Consumer;

public class IntervalHandler {

    private final int interval;
    private final Consumer<Void> action;
    private boolean isRunning;

    IntervalHandler(int interval, Consumer<Void> action) {
        this.interval = interval;
        this.action = action;
        this.isRunning = false;
    }

    void Start() {
        if (!isRunning) {
            isRunning = true;
            SimpleAnnouncer.getPlugin().getServer().getScheduler().runTaskTimer(SimpleAnnouncer.getPlugin(), () -> {
                if (isRunning) {
                    action.accept(null);
                }
            }, 0, interval * 20L);
        }
    }

    void Stop() {
        isRunning = false;
    }
}
