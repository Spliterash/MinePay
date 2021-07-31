package ru.spliterash.minepay.donates.types.command.amount;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;

@RequiredArgsConstructor
public class AmountCommandDonateGiver implements DonateGiver<AmountCommandBuyDetails> {
    private final IPlatform platform;

    @Override
    public void giveDonate(AmountCommandBuyDetails donateInfo) {
        double toGive = donateInfo.getRealMoneyAmount() * donateInfo.getDonate().getExchange();

        IPlayer player = platform.getPlayer(donateInfo.getPlayer());

        String cmd = donateInfo.getDonate().getCommand()
                .replace("%player%", player.getName())
                .replace("%amount%", String.valueOf(toGive));

        platform.runCommand(cmd);
    }
}
