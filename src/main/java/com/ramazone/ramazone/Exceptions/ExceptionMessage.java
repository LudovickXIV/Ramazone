package com.ramazone.ramazone.Exceptions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionMessage {

    private String pattern = "yyyy-MM-dd HH:mm:ssZ";
    private SimpleDateFormat simpleDateFormat;
    private String message;


    public ExceptionMessage() {
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    public ExceptionMessage(String message) {
        this.message = message;
        this.simpleDateFormat = new SimpleDateFormat(pattern);
    }

    public String getMessage() {
        return simpleDateFormat.format(new Date()) + " " + message;
    }
}
