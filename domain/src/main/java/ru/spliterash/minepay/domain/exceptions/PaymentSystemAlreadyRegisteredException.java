package ru.spliterash.minepay.domain.exceptions;

import lombok.Getter;

@Getter
public class PaymentSystemAlreadyRegisteredException extends MinePayDomainException {
    private final String name;

    public PaymentSystemAlreadyRegisteredException(String name) {
        super("Payment system with name " + name + " already registered. Unregister before register again");
        this.name = name;
    }
}
