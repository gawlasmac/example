package com.example.demo.logger;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Logger {

    public void info(final String message) {
        System.out.printf("%s INFO|%s\n", new Date(), message);
    }

    public void error(final String message, final int errorCode) {
        System.out.printf("%s ERROR|%d|%s\n", new Date(), errorCode, message);
    }

    public void error(final Exception e) {
        error(e.getMessage(), -1);
    }

}
