package ru.spliterash.minepay.domain.payment.storage;

import ru.spliterash.minepay.domain.payment.CompletedPayment;
import ru.spliterash.minepay.domain.platform.IPlayer;

import java.util.List;

public interface PaymentStorage<CP extends CompletedPayment<?>> {
    void saveCompletePayment(CP toSave);

    CP findPaymentById(String id);

    List<CP> findPlayerPayments(IPlayer player);
}
