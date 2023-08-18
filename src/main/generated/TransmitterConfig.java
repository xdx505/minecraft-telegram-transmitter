package ru.xdx505.transmitter.config;

import blue.endless.jankson.Jankson;
import io.wispforest.owo.config.ConfigWrapper;
import io.wispforest.owo.config.Option;
import io.wispforest.owo.util.Observable;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TransmitterConfig extends ConfigWrapper<ru.xdx505.transmitter.config.TransmitterConfigModel> {

    public final Keys keys = new Keys();

    private final Option<java.lang.String> tgBotName = this.optionForKey(this.keys.tgBotName);
    private final Option<java.lang.String> tgBotToken = this.optionForKey(this.keys.tgBotToken);
    private final Option<java.lang.Long> chatId = this.optionForKey(this.keys.chatId);

    private TransmitterConfig() {
        super(ru.xdx505.transmitter.config.TransmitterConfigModel.class);
    }

    private TransmitterConfig(Consumer<Jankson.Builder> janksonBuilder) {
        super(ru.xdx505.transmitter.config.TransmitterConfigModel.class, janksonBuilder);
    }

    public static TransmitterConfig createAndLoad() {
        var wrapper = new TransmitterConfig();
        wrapper.load();
        return wrapper;
    }

    public static TransmitterConfig createAndLoad(Consumer<Jankson.Builder> janksonBuilder) {
        var wrapper = new TransmitterConfig(janksonBuilder);
        wrapper.load();
        return wrapper;
    }

    public java.lang.String tgBotName() {
        return tgBotName.value();
    }

    public void tgBotName(java.lang.String value) {
        tgBotName.set(value);
    }

    public java.lang.String tgBotToken() {
        return tgBotToken.value();
    }

    public void tgBotToken(java.lang.String value) {
        tgBotToken.set(value);
    }

    public long chatId() {
        return chatId.value();
    }

    public void chatId(long value) {
        chatId.set(value);
    }


    public static class Keys {
        public final Option.Key tgBotName = new Option.Key("tgBotName");
        public final Option.Key tgBotToken = new Option.Key("tgBotToken");
        public final Option.Key chatId = new Option.Key("chatId");
    }
}

