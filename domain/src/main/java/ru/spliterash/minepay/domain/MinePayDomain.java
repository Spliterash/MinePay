package ru.spliterash.minepay.domain;

import lombok.Getter;
import ru.spliterash.minepay.domain.donate.*;
import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.base.DonatePriceCalculator;
import ru.spliterash.minepay.domain.donateTypes.fixed.FixedPriceDonate;
import ru.spliterash.minepay.domain.donateTypes.fixed.FixedDonatePriceCalculator;
import ru.spliterash.minepay.domain.exceptions.DonatAlreadyRegisteredException;
import ru.spliterash.minepay.domain.exceptions.DonateGiverNotFoundException;
import ru.spliterash.minepay.domain.exceptions.PaymentSystemAlreadyRegisteredException;
import ru.spliterash.minepay.domain.payment.system.InGame;
import ru.spliterash.minepay.domain.payment.system.PaymentSystem;
import ru.spliterash.minepay.domain.platform.IPlatform;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>Класс хранящий все данные необходимые для работы</p>
 * <p>WARNING: Здесь очень много генериков, и выглядят они очень страшно,
 * но эти генерики позволяют делать очень крутые вещи так что наверное можно потерпеть</p>
 */
public class MinePayDomain {
    /**
     * Список доступных платёжных систем
     */
    private final Set<PaymentSystem> systems = new LinkedHashSet<>();
    private final Set<DonateContainer<?, ?>> donateTypes = new HashSet<>();

    /**
     * Текущая платформа
     */
    @Getter
    private final IPlatform platform;
    /**
     * ID сервера
     */
    @Getter
    private final String serverName;

    public MinePayDomain(IPlatform platform, String serverName) {
        this.platform = platform;
        this.serverName = serverName;


    }


    public <D extends Donate> DonateContainer<D, ?> getDonateContainer(Class<D> clazz) {
        //noinspection unchecked
        return (DonateContainer<D, ?>) donateTypes.stream()
                .filter(t -> t.getDonateClazz().equals(clazz))
                .findFirst()
                .orElseThrow(() -> new DonateGiverNotFoundException(clazz));
    }

    public void registerPaymentSystem(PaymentSystem paymentSystem) {
        systems
                .stream()
                .filter(s -> s.getName().equals(paymentSystem.getName()))
                .findFirst()
                .ifPresent(s -> {
                    throw new PaymentSystemAlreadyRegisteredException(paymentSystem.getName());
                });

        systems.add(paymentSystem);
    }

    public void unregisterPaymentSystem(String name) {
        systems.removeIf(s -> s.getName().equals(name));
    }

    public void unregisterPaymentSystem(PaymentSystem system) {
        systems.remove(system);
    }

    /**
     * Данный метод вызывается в PaymentSystem после удачного совершения платежа
     *
     * @param successDonat Купленный игроком донат и его параметры
     * @param <I>          DonateContainer, доп инфа о данном типе доната
     */
    public <I extends BuyDetails<?>> void processDonate(I successDonat) {
        //noinspection unchecked
        DonateContainer<?, I> info = (DonateContainer<?, I>) getDonateContainer(successDonat.getDonate().getClass());
        info.getGiver().giveDonate(successDonat);
    }

    public List<InGame> getInGamePaymentSystems() {
        return systems
                .stream()
                .filter(s -> s instanceof InGame)
                .map(s -> (InGame) s)
                .collect(Collectors.toList());
    }

    public <D extends Donate, I extends BuyDetails<D>> void registerDonateType(
            Class<D> donatClazz,
            DonateGiver<I> donatGiver,
            DonatePriceCalculator<I> donatCalculator
    ) {
        donateTypes
                .stream()
                .filter(d -> d.getDonateClazz().equals(donatClazz))
                .findFirst()
                .ifPresent(d -> {
                    throw new DonatAlreadyRegisteredException(donatClazz);
                });

        donateTypes.add(new DonateContainer<>(
                donatClazz,
                donatCalculator,
                donatGiver
        ));
    }

    private final FixedDonatePriceCalculator<?> fixedDonatePriceCalculator = new FixedDonatePriceCalculator<>();

    public <D extends FixedPriceDonate, I extends BuyDetails<D>> void registerDonateType(Class<D> donatClazz, DonateGiver<I> donatGiver) {

        registerDonateType(
                donatClazz,
                donatGiver,
                (FixedDonatePriceCalculator<I>) fixedDonatePriceCalculator
        );
    }

}
