package com.github.sparsick.springbootexample.hero;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testcontainers.Testcontainers.exposeHostPorts;

@Testcontainers
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HeroStartPageIT {

    @Container
    private static final BrowserWebDriverContainer<?> chromeBrowser = new BrowserWebDriverContainer<>() // one browser for all tests
            .withCapabilities(new ChromeOptions())
            .withAccessToHost(true);

    @LocalServerPort
    private int heroPort;

    @Before
    void setUp(){
    }

    @Test
    void titleIsHeroSearchMachine(){
        exposeHostPorts(heroPort);
        RemoteWebDriver driver = chromeBrowser.getWebDriver();

        driver.get("http://host.testcontainers.internal:" + heroPort + "/hero");
        WebElement title = driver.findElement(By.tagName("h1"));

        assertThat(title.getText().trim())
                .isEqualTo("Hero Search Machine");
    }

    @Test
    void searchForHero(){
        exposeHostPorts(heroPort);
        RemoteWebDriver driver = chromeBrowser.getWebDriver();

        driver.get("http://host.testcontainers.internal:" + heroPort + "/hero");
        WebElement formTextField = driver.findElement(By.className("form-control"));
        formTextField.sendKeys("Batman");

        WebElement searchButton = driver.findElement(By.id("button-search"));
        searchButton.click();

        WebElement title = driver.findElement(By.tagName("h1"));



        assertThat(title.getText().trim())
                .isEqualTo("Hero List");
    }


}
