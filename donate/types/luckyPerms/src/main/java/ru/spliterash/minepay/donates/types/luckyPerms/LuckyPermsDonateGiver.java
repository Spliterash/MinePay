package ru.spliterash.minepay.donates.types.luckyPerms;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeBuilder;
import ru.spliterash.minepay.domain.donate.BuyDetails;
import ru.spliterash.minepay.domain.donate.base.DonateGiver;

import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class LuckyPermsDonateGiver implements DonateGiver<BuyDetails<LuckyPermsDonate>> {
    @SneakyThrows
    @Override
    public void giveDonate(BuyDetails<LuckyPermsDonate> donateInfo) {
        LuckPerms api = LuckPermsProvider.get();

        api
                .getUserManager()
                .modifyUser(donateInfo.getPlayer(), u -> {
                    for (String pex : donateInfo.getDonate().getPexsToAdd()) {
                        NodeBuilder<?, ?> builder = Node.builder(pex);
                        if (donateInfo.getDonate().getDays() != null)
                            builder.expiry(donateInfo.getDonate().getDays(), TimeUnit.DAYS);
                        u.data().add(builder.build());
                    }
                });


    }
}
