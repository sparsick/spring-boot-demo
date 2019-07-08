package com.github.sparsick.clouddemoapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = {
        "branch.config.username.1=admin",
        "branch.config.password.1=password"})
class ConfigDemoTest {

    @Autowired
    private ConfigDemo subjectUnderTest;

    @Test
    void testConfigDemo(){
        String username = subjectUnderTest.usernameFor(1);

        assertEquals("admin", username);

    }

}