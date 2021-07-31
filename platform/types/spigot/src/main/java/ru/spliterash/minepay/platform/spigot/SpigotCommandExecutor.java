package ru.spliterash.minepay.platform.spigot;

import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.spliterash.minepay.domain.command.def.ICommandExecutor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class SpigotCommandExecutor implements TabExecutor {
    private final SpigotPlatform platform;
    private final ICommandExecutor executor;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Sry only players");
            return true;
        }
        executor.command(platform.getPlayer((Player) sender), args);

        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (!(sender instanceof Player))
            return Collections.emptyList();

        return executor.tabComplete(platform.getPlayer((Player) sender), args);
    }
}
