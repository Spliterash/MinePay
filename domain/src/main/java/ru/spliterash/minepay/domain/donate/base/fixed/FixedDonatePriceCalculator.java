package ru.spliterash.minepay.domain.donate.base.fixed;

import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.domain.donate.base.DonatePriceCalculator;

public class FixedDonatePriceCalculator<I extends BuyDetails<? extends FixedPriceDonate>> implements DonatePriceCalculator<I> {

    @Override
    public double getPrice(I info) {
        return info.getDonate().getPrice();
    }
}
