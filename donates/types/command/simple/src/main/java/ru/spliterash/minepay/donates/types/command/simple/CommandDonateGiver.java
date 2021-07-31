package ru.spliterash.minepay.donates.types.command.simple;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;

@RequiredArgsConstructor
public class CommandDonateGiver implements DonateGiver<BuyDetails<CommandDonate>> {
    private final IPlatform platform;

    @Override
    public void giveDonate(BuyDetails<CommandDonate> buyDetails) {
        IPlayer player = platform.getPlayer(buyDetails.getPlayer());

        String cmd = buyDetails.getDonate().getCommand().replace("%player%", player.getName());

        platform.runCommand(cmd);
    }
}
