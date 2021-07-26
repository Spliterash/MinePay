package ru.spliterash.minepay.domain.payment.system;

import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.donate.BuyDetails;

/**
 * Платёжные системы которые можно вызвать прямо из игры и которые видит игрок
 */
public interface InGame extends PaymentSystem {
    <T extends Donate> void buy(BuyDetails<T> info);
}
