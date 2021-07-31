package ru.spliterash.minepay.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.*;
import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.exceptions.DonatAlreadyRegisteredException;
import ru.spliterash.minepay.domain.exceptions.DonateGiverNotFoundException;
import ru.spliterash.minepay.domain.exceptions.PaymentSystemAlreadyRegisteredException;
import ru.spliterash.minepay.domain.payment.system.InGamePaymentSystem;
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
@RequiredArgsConstructor
public class MinePayDomain {
    /**
     * Список доступных платёжных систем
     */
    private final Set<PaymentSystem<?>> systems = new LinkedHashSet<>();
    private final Set<DonateTypeDefinition<?, ?>> donateTypes = new HashSet<>();

    /**
     * Текущая платформа
     */
    @Getter
    private final IPlatform platform;
    @Getter
    private final IDonateStorage donateStorage;
    @Getter
    private final ILauncher launcher;

    public <D extends Donate> DonateTypeDefinition<D, ?> getDonateDefinition(Class<D> clazz) {
        //noinspection unchecked
        return (DonateTypeDefinition<D, ?>) donateTypes.stream()
                .filter(t -> t.getDonateClazz().equals(clazz))
                .findFirst()
                .orElseThrow(() -> new DonateGiverNotFoundException(clazz));
    }

    public void registerPaymentSystem(PaymentSystem<?> paymentSystem) {
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

    public void unregisterPaymentSystem(PaymentSystem<?> system) {
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
        DonateTypeDefinition<?, I> info = (DonateTypeDefinition<?, I>) getDonateDefinition(successDonat.getDonate().getClass());
        info.getGiver().giveDonate(successDonat);
    }

    public List<InGamePaymentSystem> getInGamePaymentSystems() {
        return systems
                .stream()
                .filter(s -> s instanceof InGamePaymentSystem)
                .map(s -> (InGamePaymentSystem) s)
                .collect(Collectors.toList());
    }

    public <D extends Donate, I extends BuyDetails<D>> void registerDonateType(DonateTypeDefinition<?, ?> definition) {
        donateTypes
                .stream()
                .filter(d -> d.getDonateClazz().equals(definition.getDonateClazz()))
                .findFirst()
                .ifPresent(d -> {
                    throw new DonatAlreadyRegisteredException(definition.getDonateClazz());
                });

        donateTypes.add(definition);
    }

    public void init() {

    }

    public void shutdown() {
        // Может быть сюда что то надо будет потом написать
    }
}
