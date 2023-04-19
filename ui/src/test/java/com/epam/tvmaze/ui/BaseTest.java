package com.epam.tvmaze.ui;

import com.epam.tvmaze.driver.Driver;
import com.epam.tvmaze.pages.HomePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected HomePage homePage;

    @BeforeMethod
    public void beforeTest() {
        homePage = new HomePage().openPage();
    }

    @AfterMethod(alwaysRun = true)
    public void closeWebDriver() {
        Driver.closeDriver();
    }
}
