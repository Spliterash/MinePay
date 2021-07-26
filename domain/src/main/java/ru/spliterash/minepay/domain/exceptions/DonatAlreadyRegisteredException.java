package ru.spliterash.minepay.domain.exceptions;

import lombok.Getter;
import ru.spliterash.minepay.domain.donate.base.Donate;

@Getter
public class DonatAlreadyRegisteredException extends MinePayDomainException {
    private final Class<?> donateClazz;

    public DonatAlreadyRegisteredException(Class<? extends Donate> clazz) {
        super("Donate " + clazz.getSimpleName() + " already registered");
        this.donateClazz = clazz;
    }
}
