package ru.spliterash.minepay.donates.types.command.simple;

import ru.spliterash.minepay.domain.donate.DonateTypeDefinition;
import ru.spliterash.minepay.domain.donate.base.fixed.FixedDonatePriceCalculator;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.types.command.AbstractCommandDefinition;

public class SimpleCommandDonateRegister extends AbstractCommandDefinition<CommandDonate> {

    public SimpleCommandDonateRegister(IPlatform platform) {
        super(platform);
    }

    @Override
    public DonateTypeDefinition<CommandDonate, ?> getDonateTypeDefinition() {
        return new DonateTypeDefinition<>(
                CommandDonate.class,
                new FixedDonatePriceCalculator<>(),
                new CommandDonateGiver(platform)
        );
    }
}
