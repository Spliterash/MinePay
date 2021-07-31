package ru.spliterash.minepay.domain.payment.system;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class PaymentSystem<T extends PaymentSystemTransactionInfo> {
    /**
     * Имя платёжной системы
     */
    private final String name;
    /**
     * Хранилище транзакций в этой платёжной системе
     */
    private final T transactionStorage;
}
