package ru.spliterash.minepay.donates.types.command;

import ru.spliterash.minepay.domain.donate.base.Donate;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.definition.ToRegisterDonate;
import ru.spliterash.minepay.platform.features.CommandPlatform;

public abstract class AbstractCommandDefinition<D extends Donate> extends ToRegisterDonate<D> {
    public AbstractCommandDefinition(IPlatform platform) {
        super(platform);
    }

    @Override
    public boolean isAcceptable() {
        return platform instanceof CommandPlatform;
    }
}
