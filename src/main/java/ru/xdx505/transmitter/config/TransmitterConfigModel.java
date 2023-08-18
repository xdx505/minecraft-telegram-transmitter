package ru.xdx505.transmitter.config;

import io.wispforest.owo.config.annotation.Config;

@Config(name = "transmitter", wrapperName = "TransmitterConfig")
public class TransmitterConfigModel {
    public String tgBotName = "";
    public String tgBotToken = "";
    public long chatId = -1;
}
