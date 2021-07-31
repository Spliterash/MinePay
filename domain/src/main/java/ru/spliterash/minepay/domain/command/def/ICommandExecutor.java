package ru.spliterash.minepay.domain.command.def;

import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;

import java.util.Collections;
import java.util.List;

public interface ICommandExecutor {
    public void command(IPlayer player, String[] args);

    default List<String> tabComplete(IPlayer player, String[] args) {
        return Collections.emptyList();
    }
}
