package ru.spliterash.minepay.domain.exceptions;

public abstract class MinePayDomainException extends RuntimeException {
    public MinePayDomainException() {
    }

    public MinePayDomainException(String message) {
        super(message);
    }

    public MinePayDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
