package ru.spliterash.minepay.domain.payment.system;

import ru.spliterash.minepay.domain.donate.BuyDetails;

/**
 * Платёжные системы которые можно вызвать прямо из игры
 */
public interface InGamePaymentSystem {
    <B extends BuyDetails<?>> void buy(B info);
}
