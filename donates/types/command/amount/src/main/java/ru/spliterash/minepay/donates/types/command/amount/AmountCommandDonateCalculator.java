package ru.spliterash.minepay.donates.types.command.amount;

import ru.spliterash.minepay.domain.donate.base.DonatePriceCalculator;

public class AmountCommandDonateCalculator implements DonatePriceCalculator<AmountCommandBuyDetails> {
    @Override
    public double getPrice(AmountCommandBuyDetails info) {
        return info.getRealMoneyAmount();
    }
}
