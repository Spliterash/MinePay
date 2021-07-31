package ru.spliterash.minepay.domain.platform;

public interface IPlayer {
    String getName();

    boolean isOnline();

    void sendMessage(String message);
}
