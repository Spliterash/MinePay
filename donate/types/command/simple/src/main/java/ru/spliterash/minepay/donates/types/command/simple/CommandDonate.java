package ru.spliterash.minepay.donates.types.command.simple;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.base.fixed.FixedPriceDonate;

@Getter
@SuperBuilder
public class CommandDonate extends FixedPriceDonate {
    /**
     * Команда которая должна выполниться от консоли
     * Вместо %player% подставляется ник игрока
     */
    private final String command;
}
