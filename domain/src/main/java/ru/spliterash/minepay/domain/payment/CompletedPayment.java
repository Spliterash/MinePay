package ru.spliterash.minepay.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.BuyDetails;

@Getter
@RequiredArgsConstructor
public abstract class CompletedPayment<B extends BuyDetails<?>> {
    private final String id;
    /**
     * Цена на момент совершения покупки
     */
    private final double price;
    /**
     * Инфа по купленному донату
     */
    private final B details;
    /**
     * Имя платёжной системы
     */
    private final String paymentSystemId;
    /**
     * Сведения от платёжной системы
     */
    private final String transactionId;

}