package ru.spliterash.minepay.domain.platform;

import ru.spliterash.minepay.domain.donate.base.Donate;

import java.util.List;
import java.util.UUID;

public interface IPlatform {
    IPlayer getPlayer(UUID uuid);

    IPlayer getPlayer(String name);

    void runCommand(String command);

    List<Donate> getDonateList();
}
