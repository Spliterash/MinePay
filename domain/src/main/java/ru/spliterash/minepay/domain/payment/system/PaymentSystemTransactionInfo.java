package ru.spliterash.minepay.domain.payment.system;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * Сведения о транзакции для конкретной платёжной системы
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public abstract class PaymentSystemTransactionInfo {
    /**
     * ID Транзакции в нашей системе
     */
    private String id;
    /**
     * Прошёл ли платёж
     */
    private boolean success;
    // Какие то доп сведения уже расширяются в зависимости от платёжной системы
}
