package ru.xdx505.transmitter.handlers;

import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import net.minecraft.network.message.MessageType;
import net.minecraft.network.message.SignedMessage;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import ru.xdx505.transmitter.TransmitterMod;
import ru.xdx505.transmitter.register.TelegramRegister;


public class ServerMessageEventHandler implements ServerMessageEvents.ChatMessage, ServerMessageEvents.GameMessage {

    @Override
    public void onChatMessage(SignedMessage message, ServerPlayerEntity sender, MessageType.Parameters params) {
        String text = String.format("<b>*%s*:</b> %s", sender.getEntityName(), message.getContent().getString());
        SendMessage sendMessage = new SendMessage(TransmitterMod.CONFIG.chatId(), text);
        sendMessage.parseMode(ParseMode.HTML);
        TelegramRegister.BOT.execute(sendMessage);
    }

    @Override
    public void onGameMessage(MinecraftServer server, Text message, boolean overlay) {
        String text = String.format("[%s]", message.getString());
        SendMessage sendMessage = new SendMessage(TransmitterMod.CONFIG.chatId(), text);
        sendMessage.parseMode(ParseMode.HTML);
        TelegramRegister.BOT.execute(sendMessage);
    }
}
