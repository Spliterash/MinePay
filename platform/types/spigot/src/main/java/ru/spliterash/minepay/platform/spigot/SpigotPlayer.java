package ru.spliterash.minepay.platform.spigot;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.OfflinePlayer;
import ru.spliterash.minepay.domain.platform.IPlayer;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class SpigotPlayer implements IPlayer {
    private final OfflinePlayer player;

    @Override
    public String getName() {
        return player.getName();
    }

    @Override
    public boolean isOnline() {
        return player.isOnline();
    }

    @Override
    public void sendMessage(String message) {
        if (player.isOnline())
            //noinspection ConstantConditions
            player.getPlayer().sendMessage(message);
    }


}
