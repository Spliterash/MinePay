package ru.spliterash.minepay.donates.types.command.amount;

import ru.spliterash.minepay.domain.donate.DonateTypeDefinition;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.types.command.AbstractCommandDefinition;

public class AmountCommandDonateRegister extends AbstractCommandDefinition<AmountCommandDonate> {
    public AmountCommandDonateRegister(IPlatform platform) {
        super(platform);
    }

    @Override
    public DonateTypeDefinition<AmountCommandDonate, ?> getDonateTypeDefinition() {
        return new DonateTypeDefinition<>(
                AmountCommandDonate.class,
                new AmountCommandDonateCalculator(),
                new AmountCommandDonateGiver(platform)
        );
    }
}
