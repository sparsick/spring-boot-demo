package com.github.sparsick.clouddemoapp;

import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Configuration
@ConfigurationProperties("branch.config")
@Validated
public class ConfigurationObject {

    @NotEmpty
    private final Map<Integer, String> username = new HashMap<>();

    @NotEmpty
    private final Map<Integer, String> password = new HashMap<>();


    public String usernameFor(int branchNumber) {
        return username.get(branchNumber);
    }

    public String passwordFor(int branchNumber) {
        return password.get(branchNumber);
    }
}
