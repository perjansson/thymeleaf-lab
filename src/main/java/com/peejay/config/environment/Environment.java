package com.peejay.config.environment;

import org.springframework.stereotype.Component;

public class Environment {

    private String name;

    public Environment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
