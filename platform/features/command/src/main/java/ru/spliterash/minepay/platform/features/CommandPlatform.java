package ru.spliterash.minepay.platform.features;

import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;

/**
 * Платформа поддерживает выполнение команд
 */
@SuppressWarnings("unused")
public interface CommandPlatform extends IPlatform {
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
