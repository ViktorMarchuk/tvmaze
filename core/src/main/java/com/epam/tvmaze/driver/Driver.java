package com.epam.tvmaze.driver;

import com.epam.tvmaze.browser.WebDriverFactory;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigEnumDriverRemote;
import com.epam.tvmaze.utils.ConfigReader;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class Driver {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<WebDriver>();

    private Driver() {
    }

    public static synchronized WebDriver getInstance() {
        if (Objects.isNull(getThreadLocalDriver())) {
            WebDriver driver = isRemote() ?
                    createRemoteInstance() : WebDriverFactory.installDriver(getValueOfBrowser());
            threadLocalDriver.set(driver);
        }
        WebDriver driver = getThreadLocalDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static boolean isRemote() {
        String remoteDriverSystem = System.getProperty(ConfigEnumDriverRemote.REMOTE.getParam());
        return Objects.nonNull(remoteDriverSystem) ?
                Boolean.parseBoolean(remoteDriverSystem) :
                Boolean.parseBoolean(ConfigReader.getValue(ConfigEnumDriverRemote.REMOTE));
    }

    private static synchronized WebDriver getThreadLocalDriver() {
        return threadLocalDriver.get();
    }

    private static DriverManagerType getValueOfBrowser() {
        String browserSystem = System.getProperty("browser");
        return Objects.isNull(browserSystem) ?
                DriverManagerType.valueOf(ConfigReader.getValue(ConfigEnum.BROWSER).toUpperCase()) :
                DriverManagerType.valueOf(browserSystem.toUpperCase());
    }

    private static WebDriver createRemoteInstance() {
        String url = String.format("https://%s:%s%s",
                ConfigReader.getValue(ConfigEnumDriverRemote.USER_NAME),
                ConfigReader.getValue(ConfigEnumDriverRemote.ACCESS_KEY),
                ConfigReader.getValue(ConfigEnumDriverRemote.LT_URL));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", ConfigReader.getValue(ConfigEnumDriverRemote.BROWSER_NAME));
        capabilities.setCapability("browserVersion", ConfigReader.getValue(ConfigEnumDriverRemote.BROWSER_VERSION));
        capabilities.setCapability("platform", ConfigReader.getValue(ConfigEnumDriverRemote.PLATFORM));
        capabilities.setCapability("buildName", ConfigReader.getValue(ConfigEnumDriverRemote.BUILD_NAME));

        try {
            return new RemoteWebDriver(new URL(url), capabilities);
        } catch (MalformedURLException e) {
            throw new WebDriverManagerException("RemoteWebDriver can not be created");
        }
    }

    public static void closeDriver() {
        getInstance().quit();
        threadLocalDriver.remove();
    }
}
