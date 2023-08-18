package ru.xdx505.transmitter.register;

import com.pengrad.telegrambot.TelegramBot;
import net.minecraft.server.MinecraftServer;
import ru.xdx505.transmitter.config.TransmitterConfig;
import ru.xdx505.transmitter.listener.TelegramUpdatesListener;

public class TelegramRegister {
    public static TelegramBot BOT;


    public static void registerEventsAndTelegram(MinecraftServer server, TransmitterConfig config) {
        BOT = new TelegramBot(config.tgBotToken());

        TelegramUpdatesListener telegramUpdatesListener = new TelegramUpdatesListener(server);
        BOT.setUpdatesListener(telegramUpdatesListener);
    }
}
