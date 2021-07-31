package ru.spliterash.minepay.donates;

import ru.spliterash.minepay.domain.donate.DonateTypeDefinition;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.definition.ToRegisterDonate;
import ru.spliterash.minepay.donates.types.command.amount.AmountCommandDonateRegister;
import ru.spliterash.minepay.donates.types.command.simple.SimpleCommandDonateRegister;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Возможно выглядит странно, но этот метод просто собирает всё что можно зарегать в кучу
 */
public class DonateRegister {
    public static List<DonateTypeDefinition<?, ?>> getPluginDonates(IPlatform platform) {
        return Stream.of(
                        new SimpleCommandDonateRegister(platform),
                        new AmountCommandDonateRegister(platform)
                )
                .filter(ToRegisterDonate::isAcceptable)
                .map(ToRegisterDonate::getDonateTypeDefinition)
                .collect(Collectors.toList());
    }
}
