package ru.xdx505.transmitter;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import ru.xdx505.transmitter.config.TransmitterConfig;
import ru.xdx505.transmitter.register.EventsRegister;
import ru.xdx505.transmitter.register.TelegramRegister;

public class TransmitterMod implements ModInitializer {
    public static TransmitterConfig CONFIG;

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            CONFIG = TransmitterConfig.createAndLoad();
            TelegramRegister.registerEventsAndTelegram(server, CONFIG);
            EventsRegister.registerEvents();
        });
    }
}