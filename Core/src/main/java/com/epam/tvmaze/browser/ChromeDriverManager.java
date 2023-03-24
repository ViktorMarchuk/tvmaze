package com.epam.tvmaze.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;

public class ChromeDriverManager implements DriverManager {
    private final ChromeOptions chromeOptions = new ChromeOptions();

    @Override
    public WebDriver createDriver() {
        WebDriverManager.getInstance(CHROME).setup();
        setChromeOptions();
        return new ChromeDriver(chromeOptions);
    }

    private void setChromeOptions() {
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--lang=en-US");
    }
}
