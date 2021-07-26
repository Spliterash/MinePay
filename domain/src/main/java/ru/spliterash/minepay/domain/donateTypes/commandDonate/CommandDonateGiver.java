package ru.spliterash.minepay.domain.donateTypes.commandDonate;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;
import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.domain.platform.IPlatform;

@RequiredArgsConstructor
public class CommandDonateGiver implements DonateGiver<BuyDetails<CommandDonate>> {
    private final IPlatform platform;

    @Override
    public void giveDonate(BuyDetails<CommandDonate> buyDetails) {
        String cmd = buyDetails.getDonate().getCommand().replace("%player%", buyDetails.getPlayer().getName());

        platform.runCommand(cmd);
    }
}
