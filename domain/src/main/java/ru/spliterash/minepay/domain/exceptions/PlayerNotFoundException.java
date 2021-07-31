package ru.spliterash.minepay.domain.exceptions;

import java.util.UUID;

public class PlayerNotFoundException extends MinePayDomainException {
    public PlayerNotFoundException(String name) {
        super("Player not found by name: " + name);
    }

    public PlayerNotFoundException(UUID uuid) {
        super("Player not found by uuid: " + uuid);
    }
}
