package ru.spliterash.minepay.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.BuyDetails;

@Getter
@RequiredArgsConstructor
public abstract class CompletedPayment<B extends BuyDetails<?>> {
    /**
     * ID платежа в нашей дбшке
     */
    private final String id;
    /**
     * Инфа по купленному донату
     */
    private final B details;
    /**
     * Цена на момент совершения покупки
     */
    private final double price;
    /**
     * Имя платёжной системы
     */
    private final String paymentSystemName;
    /**
     * Сведения от платёжной системы
     */
    private final String transactionId;

}
