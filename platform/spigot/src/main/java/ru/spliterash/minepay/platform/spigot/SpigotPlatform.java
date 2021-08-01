package ru.spliterash.minepay.platform.spigot;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spliterash.minepay.domain.command.def.ICommandExecutor;
import ru.spliterash.minepay.domain.exceptions.PlayerNotFoundException;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;
import ru.spliterash.minepay.launcher.MinePayLauncher;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

public class SpigotPlatform extends JavaPlugin implements IPlatform {
    private MinePayLauncher launcher;

    @Override
    public void onEnable() {
        launcher = new MinePayLauncher(this);
        launcher.onEnable();
    }

    @Override
    public void onDisable() {
        launcher.onDisable();
        launcher = null;
    }

    public IPlayer getPlayer(Player player) {
        return new SpigotPlayer(player);
    }

    @Override
    public IPlayer getPlayer(UUID uuid) {
        OfflinePlayer player = getServer().getOfflinePlayer(uuid);
        //noinspection ConstantConditions ЭТО П****, оно может спокойно null вернуть
        if (player == null)
            throw new PlayerNotFoundException(uuid);

        return new SpigotPlayer(player);
    }

    @Override
    public IPlayer getPlayer(String name) {
        OfflinePlayer player = getServer().getOfflinePlayer(name);
        //noinspection ConstantConditions
        if (player == null)
            throw new PlayerNotFoundException(name);

        return new SpigotPlayer(player);
    }

    @Override
    public void runCommand(IPlayer player, String command) {
        getServer().dispatchCommand(Objects.requireNonNull(((SpigotPlayer) player).getPlayer().getPlayer()), command);
    }

    @Override
    public void runCommand(String command) {
        getServer().dispatchCommand(getServer().getConsoleSender(), command);
    }

    @Override
    public void registerCommand(String command, ICommandExecutor handler) {
        //noinspection ConstantConditions
        getCommand(command).setExecutor(new SpigotCommandExecutor(this, handler));
    }

    @Override
    public File getFolder() {
        return getDataFolder();
    }
}
