package ru.spliterash.minepay.domain.donateTypes.amountDonate;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.BuyDetails;

@Getter
@SuperBuilder
public class AmountCommandBuyDetails extends BuyDetails<AmountCommandDonate> {
    /**
     * Сколько игрок хочет внести в рублях или другой НАСТОЯЩЕЙ валюте
     */
    private final double realMoneyAmount;
}
