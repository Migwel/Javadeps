package dev.migwel.javadeps.exception;

public class FetchException extends RuntimeException{

    public FetchException(String msg) {
        super(msg);
    }
    public FetchException(String msg, Throwable e) {
        super(msg, e);
    }
}
