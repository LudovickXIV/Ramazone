package com.ramazone.ramazone.Exceptions;

public class UserNotFoundException extends IllegalStateException {


    private StackTraceElement[] stackTraceElement;
    private ExceptionMessage message;

    public UserNotFoundException(Thread c) {
        setStackTrace(stackTraceElement);
        message = new ExceptionMessage();
    }

    public UserNotFoundException(Thread c, String msg) {
        setStackTrace(c.getStackTrace());
        message = new ExceptionMessage(msg);
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public void setStackTrace(StackTraceElement[] stackTrace) {
        stackTraceElement = new StackTraceElement[]{stackTrace[2]};
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return this.stackTraceElement;
    }

    @Override
    public String getLocalizedMessage() {
        return message.getMessage();
    }

    @Override
    public String getMessage() {
        return message.getMessage();
    }
}
