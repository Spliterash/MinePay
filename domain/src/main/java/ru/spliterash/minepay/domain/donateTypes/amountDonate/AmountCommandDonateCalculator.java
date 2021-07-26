package ru.spliterash.minepay.domain.donateTypes.amountDonate;

import ru.spliterash.minepay.domain.donate.base.DonatePriceCalculator;

public class AmountCommandDonateCalculator implements DonatePriceCalculator<AmountCommandBuyDetails> {
    @Override
    public double getPrice(AmountCommandBuyDetails info) {
        return info.getRealMoneyAmount();
    }
}
