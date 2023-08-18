package ru.xdx505.transmitter.listener;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import net.minecraft.server.MinecraftServer;
import net.minecraft.text.Text;

import java.util.List;

public class TelegramUpdatesListener implements UpdatesListener {
    private final MinecraftServer server;

    public TelegramUpdatesListener(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            Message message = update.message();
            if (message != null && message.text() != null) {
                String text = processChatMessage(message);
                server.getPlayerManager().broadcast(Text.of(text), false);
            }
        });
        return -1;
    }

    private String processChatMessage(Message message) {
        String username = message.from().username();
        String text = message.text();
        return String.format("§f§bTelegram§f / §f<§6%s§f> %s", username, text);
    }
}
