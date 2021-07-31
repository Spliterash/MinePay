package ru.spliterash.minepay.launcher;

import ru.spliterash.minepay.domain.MinePayDomain;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.DonateRegister;

/**
 * Класс запускающий плагин
 */
public class MinePayLauncher {
    private final IPlatform platform;
    private MinePayDomain domain;

    public MinePayLauncher(IPlatform platform) {
        this.platform = platform;
    }

    public void onEnable() {
        this.domain = new MinePayDomain(platform);
        registerDonates();
    }

    private void registerDonates() {
        DonateRegister.getPluginDonates(platform).forEach(d -> domain.registerDonateType(d));
    }

    public void onDisable() {
        domain.onDisable();
    }

    public void restart() {
        onDisable();
        onEnable();
    }
}
