package ru.spliterash.minepay.platform.spigot;

import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.java.JavaPlugin;
import ru.spliterash.minepay.domain.exceptions.PlayerNotFoundException;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.domain.platform.IPlayer;
import ru.spliterash.minepay.launcher.MinePayLauncher;

import java.util.Objects;
import java.util.UUID;

public class SpigotPlatform extends JavaPlugin implements IPlatform {
    private final MinePayLauncher launcher = new MinePayLauncher(this);

    @Override
    public void onEnable() {
        launcher.onEnable();
    }

    @Override
    public void onDisable() {
        launcher.onDisable();
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
}
