package ru.spliterash.minepay.domain.exceptions;

import lombok.Getter;
import ru.spliterash.minepay.domain.donate.base.Donate;

@Getter
public class DonateGiverNotFoundException extends MinePayDomainException {
    private final Class<? extends Donate> donateClass;

    public DonateGiverNotFoundException(Class<? extends Donate> donateClass) {
        super("Cant find donate giver for " + donateClass.getSimpleName());
        this.donateClass = donateClass;
    }
}
