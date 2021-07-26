package ru.spliterash.minepay.domain.donate.base;

import ru.spliterash.minepay.domain.donate.BuyDetails;

public interface DonatePriceCalculator<I extends BuyDetails<?>> {
    double getPrice(I info);
}
