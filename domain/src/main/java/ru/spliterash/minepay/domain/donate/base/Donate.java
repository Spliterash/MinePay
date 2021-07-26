package ru.spliterash.minepay.domain.donate.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * Базовое описание доната
 */
@Getter
@AllArgsConstructor
@SuperBuilder
public abstract class Donate {
    /**
     * ID доната, строкой, менять нельзя
     */
    private final String id;
    /**
     * Цветной титл
     */
    private final String title;
    /**
     * Описание
     */
    private final String description;
}
