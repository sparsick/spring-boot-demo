package com.github.sparsick.springbootexample.hero;


import org.junit.jupiter.api.BeforeEach;
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
class HeroStartPageIT {

    @Container
    private static final BrowserWebDriverContainer<?> chromeBrowserContainer = new BrowserWebDriverContainer<>() // one browser for all tests
            .withCapabilities(new ChromeOptions())
            .withAccessToHost(true);

    @LocalServerPort
    private int heroPort;

    private RemoteWebDriver browser;


    @BeforeEach
    void setUp(){
        exposeHostPorts(heroPort);
        browser = chromeBrowserContainer.getWebDriver();

        browser.get("http://host.testcontainers.internal:" + heroPort + "/hero");
    }

    @Test
    void titleIsHeroSearchMachine(){
        WebElement title = browser.findElement(By.tagName("h1"));
        assertThat(title.getText().trim())
                .isEqualTo("Hero Search Machine");
    }

    @Test
    void searchForHero(){
        WebElement formTextField = browser.findElement(By.id("search"));
        formTextField.sendKeys("Batman");

        WebElement searchButton = browser.findElement(By.id("button-search"));
        searchButton.click();

        WebElement title = browser.findElement(By.tagName("h1"));
        assertThat(title.getText().trim())
                .isEqualTo("Hero List");
    }

    @Test
    void addNewHero(){
        WebElement addNewHeroLink = browser.findElement(By.id("button-add"));
        addNewHeroLink.click();

        WebElement title = browser.findElement(By.tagName("h1"));
        assertThat(title.getText().trim())
                .isEqualTo("New Hero");
    }


}
