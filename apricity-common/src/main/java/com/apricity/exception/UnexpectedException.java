package com.apricity.exception;


public class UnexpectedException extends RuntimeException {
    private static final long serialVersionUID = 6036721898128842632L;

    public UnexpectedException(String msg) {
        super(msg);
    }

    public UnexpectedException(Throwable t) {
        super(t);
    }
}
