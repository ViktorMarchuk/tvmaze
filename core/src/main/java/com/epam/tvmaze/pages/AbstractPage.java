package com.epam.tvmaze.pages;

import com.epam.tvmaze.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage() {
        driver = Driver.getInstance();
        PageFactory.initElements(driver, this);
    }

    public List <String> getTextFromArrayXpath(String xpath){
        List <WebElement> elements = driver.findElements(By.xpath(xpath));
        List <String> result = new ArrayList <>();
        for(WebElement e: elements){
            String text = e.getText().replaceAll("\\d+(\\.\\d+)?", "");
            text = text.replace("\n", " ");
            result.add(text.trim());
        }
        return result;
    }
}
