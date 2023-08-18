package ru.xdx505.transmitter.register;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.message.v1.ServerMessageEvents;
import ru.xdx505.transmitter.handlers.ServerLifecycleEventHandler;
import ru.xdx505.transmitter.handlers.ServerMessageEventHandler;

public class EventsRegister {
    public static void registerEvents() {
        final ServerMessageEventHandler serverMessageEventHandler = new ServerMessageEventHandler();
        ServerMessageEvents.CHAT_MESSAGE.register(serverMessageEventHandler);
        ServerMessageEvents.GAME_MESSAGE.register(serverMessageEventHandler);

        final ServerLifecycleEventHandler serverLifecycleEventHandler = new ServerLifecycleEventHandler();
        ServerLifecycleEvents.SERVER_STARTED.register(serverLifecycleEventHandler);
        ServerLifecycleEvents.SERVER_STOPPING.register(serverLifecycleEventHandler);
    }
}
