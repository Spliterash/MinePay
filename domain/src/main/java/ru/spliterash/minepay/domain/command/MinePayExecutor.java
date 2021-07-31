package ru.spliterash.minepay.domain.command;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.MinePayDomain;
import ru.spliterash.minepay.domain.command.def.ICommandExecutor;
import ru.spliterash.minepay.domain.platform.IPlayer;

@RequiredArgsConstructor
public class MinePayExecutor implements ICommandExecutor {
    private final MinePayDomain domain;

    @Override
    public void command(IPlayer player, String[] args) {

    }
}
