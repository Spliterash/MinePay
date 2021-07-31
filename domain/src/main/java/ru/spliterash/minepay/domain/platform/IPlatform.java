package ru.spliterash.minepay.domain.platform;

import java.util.UUID;

public interface IPlatform {
    IPlayer getPlayer(UUID uuid);

    IPlayer getPlayer(String name);

    /**
     * Выполнить команду от игрока
     *
     * @param player  От чьего имени будет выполнено
     * @param command Команда без слеша
     */
    void runCommand(IPlayer player, String command);

    /**
     * Выполнить команду с наивысшими правами, то есть от консоли сервера
     */
    void runCommand(String command);
}
