package com.dubboclub.dk.web.exception;

public class DataHadChangedException extends IllegalStateException {

	private static final long serialVersionUID = 6769332433818524402L;

	public DataHadChangedException() {
    }

    public DataHadChangedException(String s) {
        super(s);
    }

    public DataHadChangedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataHadChangedException(Throwable cause) {
        super(cause);
    }
}
