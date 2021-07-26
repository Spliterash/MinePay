package ru.spliterash.minepay.domain.platform;

import java.util.List;

/**
 * Строки в плаге
 */
public interface ILang {
    String getLine(String path);

    List<String> getLines();
}
