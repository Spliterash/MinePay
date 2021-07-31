package ru.spliterash.minepay.donate.storage.yaml;

import lombok.RequiredArgsConstructor;
import ru.spliterash.minepay.domain.IDonateStorage;
import ru.spliterash.minepay.domain.donate.base.Donate;

import java.io.File;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class DonateYamlStorage implements IDonateStorage {
    private final File file;

    @Override
    public List<Donate> getDonates() {
        // TODO Реализовать сериализацию донутов
        return Collections.emptyList();
    }
}
