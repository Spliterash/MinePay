package ru.spliterash.minepay.donates.types.command.simple;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.domain.platform.IPlayer;
import ru.spliterash.minepay.platform.features.CommandPlatform;

@RequiredArgsConstructor
public class CommandDonateGiver implements DonateGiver<BuyDetails<CommandDonate>> {
    private final CommandPlatform platform;

    @Override
    public void giveDonate(BuyDetails<CommandDonate> buyDetails) {
        IPlayer player = platform.getPlayer(buyDetails.getPlayer());

        String cmd = buyDetails.getDonate().getCommand().replace("%player%", player.getName());

        platform.runCommand(cmd);
    }
}
