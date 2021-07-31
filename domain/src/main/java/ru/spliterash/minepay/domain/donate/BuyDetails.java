package ru.spliterash.minepay.domain.donate;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.platform.IPlayer;

import java.util.UUID;

/**
 * Сведения о покупке, содержат как минимум донат и игрока, как максимум расширяются
 */
@Getter
@SuperBuilder
public class BuyDetails<D extends Donate> {
    private final D donate;
    private final UUID player;
}
