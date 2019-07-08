package com.github.sparsick.clouddemoapp;

import org.springframework.stereotype.Component;

@Component
public class ConfigDemo {

    private final ConfigurationObject configurationObject;

    public ConfigDemo(ConfigurationObject configurationObject) {
        this.configurationObject = configurationObject;
    }

    public String usernameFor(int branchNumber) {
       return configurationObject.usernameFor(branchNumber);
    }
}
