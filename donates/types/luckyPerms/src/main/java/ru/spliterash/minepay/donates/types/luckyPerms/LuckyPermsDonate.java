package ru.spliterash.minepay.donates.types.luckyPerms;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import ru.spliterash.minepay.domain.donate.base.fixed.FixedPriceDonate;

import java.util.List;

@Getter
@SuperBuilder
public class LuckyPermsDonate extends FixedPriceDonate {
    private final List<String> pexsToAdd;
    private final Integer days;
}
