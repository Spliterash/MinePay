package ru.spliterash.minepay.domain.donate.base.fixed;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.base.Donate;

/**
 * Поскольку донаты с фиксированной ценой будут использоваться НАМНОГО чаще чем с кастомной
 * можно положить его прям в домен и подвязать
 */
@Getter
@SuperBuilder
public abstract class FixedPriceDonate extends Donate {
    private final double price;
}
