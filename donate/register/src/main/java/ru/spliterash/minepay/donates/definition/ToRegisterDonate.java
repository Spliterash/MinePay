package ru.spliterash.minepay.donates.definition;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.DonateTypeDefinition;
import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.platform.IPlatform;

@RequiredArgsConstructor
public abstract class ToRegisterDonate<D extends Donate> {
    protected final IPlatform platform;

    /**
     * Вызывать метод ТОЛЬКО после проверки isAcceptable
     */
    public abstract DonateTypeDefinition<D, ?> getDonateTypeDefinition();

    /**
     * Метод проверяет можно ли обрабатывать донаты этого типа
     */
    public abstract boolean isAcceptable();
}
