package ru.spliterash.minepay.launcher;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.IDonateStorage;
import ru.spliterash.minepay.domain.ILauncher;
import ru.spliterash.minepay.domain.MinePayDomain;
import ru.spliterash.minepay.domain.platform.IPlatform;
import ru.spliterash.minepay.donate.storage.yaml.DonateYamlStorage;
import ru.spliterash.minepay.donates.DonateRegister;

import java.io.File;

/**
 * Запускалка которая связывает все реализации ВОЕДИНА
 * <p>
 * Эта штука не знает только о лаунчере, но знает обо всём остальном
 */
@RequiredArgsConstructor
public class MinePayLauncher implements ILauncher {
    private final IPlatform platform;
    private MinePayDomain domain;
    private IDonateStorage donateStorage;

    public void onEnable() {
        this.donateStorage = new DonateYamlStorage(new File(platform.getFolder(), "donate.yml"));
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
