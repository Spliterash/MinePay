package ru.spliterash.minepay.domain.donate;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.base.DonatePriceCalculator;

/**
 * Описание отдельного типа доната, как с ним работать
 *
 * @param <D> Собственно сам донат
 * @param <I> Детали доната при покупке
 */
@Getter
@Builder
@RequiredArgsConstructor
public class DonateTypeDefinition<D extends Donate, I extends BuyDetails<D>> {
    /**
     * Класс описываемого доната
     */
    private final Class<D> donateClazz;
    /**
     * Штука расчитывающая цену доната, например может быть кастомная цена если игрок покупает валюту
     */
    private final DonatePriceCalculator<I> priceCalculator;
    /**
     * Штука выдающая донат игроку
     */
    private final DonateGiver<I> giver;

}
