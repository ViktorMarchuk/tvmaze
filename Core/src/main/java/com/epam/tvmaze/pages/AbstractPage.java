package com.epam.tvmaze.pages;

import com.epam.tvmaze.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        driver = Driver.getInstance();
        PageFactory.initElements(driver, this);
    }
}
