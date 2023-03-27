package com.epam.tvmaze.driver;

import com.epam.tvmaze.browser.WebDriverFactory;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class Driver {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    private Driver() {
    }

    public static WebDriver getInstance() {
        if (Objects.isNull(getThreadLocalDriver())) {
            WebDriver driver = WebDriverFactory.installDriver(getValueOfBrowser());
            threadLocalDriver.set(driver);
            driver.navigate().to("http://localhost:8080/leiloes");
        }
        WebDriver driver = getThreadLocalDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    private static DriverManagerType getValueOfBrowser() {
        String browserSystem = System.getProperty("browser");
        return Objects.isNull(browserSystem) ?
                DriverManagerType.valueOf(ConfigReader.getValue(ConfigEnum.BROWSER).toUpperCase()) :
                DriverManagerType.valueOf(browserSystem.toUpperCase());
    }

    public static void closeDriver() {
        getInstance().quit();
        threadLocalDriver.remove();
    }
}
