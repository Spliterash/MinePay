package ru.spliterash.minepay.domain.donateTypes.amountDonate;

import lombok.Builder;
import lombok.Getter;
import ru.spliterash.minepay.domain.donate.base.Donate;

/**
 * То же самое что и команды, но так же содержит какое то число
 * чаще всего это будет валюта
 * В команду добавляется новая переменная %amount%
 */
@Getter
public class AmountCommandDonate extends Donate {
    /**
     * Команда
     * %player% на ник игрока
     * %amount% на значение, дробное значение разделено точкой
     */
    private final String command;
    /**
     * Курс обмена, сколько будут давать за 1 реальную валюту
     */
    private final double exchange;
    /**
     * Минимальное колво реал денек
     */
    private final double minAmount;
    /**
     * Максимальное колво реал денек
     */
    private final double maxAmount;

    @Builder
    public AmountCommandDonate(String id, String title, String description, String command, double exchange, double minAmount, double maxAmount) {
        super(id, title, description);
        this.command = command;
        this.exchange = exchange;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }
}
