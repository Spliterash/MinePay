package ru.spliterash.minepay.donates.types.command.amount;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.platform.features.CommandPlatform;

@RequiredArgsConstructor
public class AmountCommandDonateGiver implements DonateGiver<AmountCommandBuyDetails> {
    private final CommandPlatform platform;

    @Override
    public void giveDonate(AmountCommandBuyDetails donateInfo) {
        double toGive = donateInfo.getRealMoneyAmount() * donateInfo.getDonate().getExchange();

        String cmd = donateInfo.getDonate().getCommand()
                .replace("%player%", donateInfo.getPlayer().getName())
                .replace("%amount%", String.valueOf(toGive));

        platform.runCommand(cmd);
    }
}
