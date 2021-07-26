package ru.spliterash.minepay.domain.donateTypes.amountDonate;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.platform.IPlatform;

@RequiredArgsConstructor
public class AmountCommandDonateGiver implements DonateGiver<AmountCommandBuyDetails> {
    private final IPlatform platform;

    @Override
    public void giveDonate(AmountCommandBuyDetails donateInfo) {
        double toGive = donateInfo.getRealMoneyAmount() * donateInfo.getDonate().getExchange();

        String cmd = donateInfo.getDonate().getCommand()
                .replace("%player%", donateInfo.getPlayer().getName())
                .replace("%amount%", String.valueOf(toGive));

        platform.runCommand(cmd);
    }
}
