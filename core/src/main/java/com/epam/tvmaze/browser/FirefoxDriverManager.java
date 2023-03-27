package com.epam.tvmaze.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class FirefoxDriverManager implements DriverManager {
    private final FirefoxOptions firefoxOptions = new FirefoxOptions();

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();
        setFirefoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }

    private void setFirefoxOptions() {
        firefoxOptions.addArguments("--lang=en-US");
    }
}
