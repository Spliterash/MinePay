package ru.spliterash.minepay.domain.platform;

import java.util.UUID;

public interface IPlatform {
    IPlayer getPlayer(UUID uuid);

    IPlayer getPlayer(String name);
}
