package ru.xdx505.transmitter.handlers;

import com.pengrad.telegrambot.request.SendMessage;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import ru.xdx505.transmitter.TransmitterMod;
import ru.xdx505.transmitter.register.TelegramRegister;

public class ServerLifecycleEventHandler implements ServerLifecycleEvents.ServerStarted, ServerLifecycleEvents.ServerStopping {
    @Override
    public void onServerStarted(MinecraftServer server) {
        String text = "[Server started]";
        SendMessage sendMessage = new SendMessage(TransmitterMod.CONFIG.chatId(), text);
        TelegramRegister.BOT.execute(sendMessage);
    }

    @Override
    public void onServerStopping(MinecraftServer server) {
        String text = "[Server stopping...]";
        SendMessage sendMessage = new SendMessage(TransmitterMod.CONFIG.chatId(), text);
        TelegramRegister.BOT.execute(sendMessage);
    }
}
