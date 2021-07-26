package ru.spliterash.minepay.domain.donateTypes.commandDonate;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donateTypes.fixed.FixedPriceDonate;

@Getter
@SuperBuilder
public class CommandDonate extends FixedPriceDonate {
    /**
     * Команда которая должна выполниться от консоли
     * Вместо %player% подставляется ник игрока
     */
    private final String command;
}
