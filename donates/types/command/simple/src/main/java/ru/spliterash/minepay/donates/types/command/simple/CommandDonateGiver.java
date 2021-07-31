package ru.spliterash.minepay.donates.types.command.simple;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.platform.features.CommandPlatform;

@RequiredArgsConstructor
public class CommandDonateGiver implements DonateGiver<BuyDetails<CommandDonate>> {
    private final CommandPlatform platform;

    @Override
    public void giveDonate(BuyDetails<CommandDonate> buyDetails) {
        String cmd = buyDetails.getDonate().getCommand().replace("%player%", buyDetails.getPlayer().getName());

        platform.runCommand(cmd);
    }
}
