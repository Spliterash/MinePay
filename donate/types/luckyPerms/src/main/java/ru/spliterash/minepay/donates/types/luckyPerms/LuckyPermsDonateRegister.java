package ru.spliterash.minepay.donates.types.luckyPerms;

import ru.spliterash.minepay.domain.donate.DonateTypeDefinition;
import ru.spliterash.minepay.domain.donate.base.fixed.FixedDonatePriceCalculator;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.definition.ToRegisterDonate;

public class LuckyPermsDonateRegister extends ToRegisterDonate<LuckyPermsDonate> {
    public LuckyPermsDonateRegister(IPlatform platform) {
        super(platform);
    }

    @Override
    public DonateTypeDefinition<LuckyPermsDonate, ?> getDonateTypeDefinition() {
        return new DonateTypeDefinition<>(
                LuckyPermsDonate.class,
                new FixedDonatePriceCalculator<>(),
                new LuckyPermsDonateGiver()
        );
    }

    @Override
    public boolean isAcceptable() {
        try {
            Class.forName("net.luckperms.api.LuckPerms");
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
