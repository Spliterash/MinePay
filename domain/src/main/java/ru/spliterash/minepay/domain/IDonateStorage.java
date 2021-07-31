package ru.spliterash.minepay.domain;

import ru.spliterash.minepay.domain.donate.base.Donate;

import java.util.List;

public interface IDonateStorage {
    List<Donate> getDonates();
}
