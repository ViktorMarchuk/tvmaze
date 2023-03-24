package com.epam.tvmaze.ui;

import com.epam.tvmaze.driver.Driver;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    @BeforeMethod
    public void openPage() {
        Driver.getInstance().navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
    }

    @AfterMethod
    public void closeWebDriver() {
        Driver.closeDriver();
    }
}
