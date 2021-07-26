package ru.spliterash.minepay.domain.donate.base;

import ru.spliterash.minepay.domain.donate.BuyDetails;

/**
 * Штука выдающая донаты игрокам
 * 1 генерик это успешный донат, те с доп инфой и игроком
 * 2 генерик это описание доната, те его базовая информация
 */
public interface DonateGiver<I extends BuyDetails<?>> {
    void giveDonate(I donateInfo);
}
