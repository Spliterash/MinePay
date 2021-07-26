package ru.spliterash.minepay.domain.donateTypes.fixed;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.base.Donate;

@Getter
@SuperBuilder
public abstract class FixedPriceDonate extends Donate {
    private final double price;
}
