package com.example.demo.logger;

import org.springframework.stereotype.Component;

@Component
public class Logger {

    public void info(final String message) {
        System.out.printf("INFO|%s", message);
    }

    public void error(final String message, final int errorCode) {
        System.out.printf("ERROR|%d|%s%n", errorCode, message);
    }

    public void error(final Exception e) {
        error(e.getMessage(), -1);
    }

}
