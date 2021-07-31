package ru.spliterash.minepay.launcher;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.IDonateStorage;
import ru.spliterash.minepay.domain.ILauncher;
import ru.spliterash.minepay.domain.MinePayDomain;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donates.DonateRegister;

/**
 * Класс запускающий плагин
 */
@RequiredArgsConstructor
public class MinePayLauncher implements ILauncher {
    private final IPlatform platform;
    private final IDonateStorage donateStorage;
    private MinePayDomain domain;

    public void onEnable() {
        this.domain = new MinePayDomain(platform, donateStorage, this);
        registerDonates();
    }

    private void registerDonates() {
        DonateRegister.getPluginDonates(platform).forEach(d -> domain.registerDonateType(d));
    }

    public void onDisable() {
        domain.shutdown();
    }

    @Override
    public void reload() {
        onDisable();
        onEnable();
    }
}
