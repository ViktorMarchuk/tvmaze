package com.epam.tvmaze.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class PeoplePage extends HomePage {
    @FindBy(xpath = "//h1[@class='show-for-medium']")
    private WebElement labelName;
    @FindBy(xpath = "//a[contains(@href, '/people/' ) and @itemprop = 'url']")
    private WebElement linkUrl;

    public String getNameAndSurname() {
        log.info(String.format("Person's name and surname - %s", labelName.getText()));
        return labelName.getText();
    }

    public String getUrl() {
        log.info(String.format("Url for person - %s", linkUrl.getAttribute("href")));
        return linkUrl.getAttribute("href");
    }

    public String getCountryName() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String countryValue = ((String) javascriptExecutor.executeScript
                ("return document.evaluate(\"//div[@id='general-info-panel']//strong[contains(text(),'Born')]" +
                        "/following-sibling::text()[1]\", document, null, XPathResult.STRING_TYPE, null).stringValue;"))
                .trim();
        log.info(countryValue);
        return countryValue;
    }

    public String getPersonBirthday() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String birthdayValue = ((String) javascriptExecutor.executeScript
                ("return document.evaluate(\"//div[@id='general-info-panel']//strong[contains(text(),'Birthday')]" +
                        "/following-sibling::text()[1]\", document, null, XPathResult.STRING_TYPE, null).stringValue;"))
                .trim();
        log.info(birthdayValue);
        return birthdayValue;
    }

    public String getPersonGender() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String genderValue = ((String) javascriptExecutor.executeScript
                ("return document.evaluate(\"//div[@id='general-info-panel']//strong[contains(text(),'Gender:')]" +
                        "/following-sibling::text()[1]\", document, null, XPathResult.STRING_TYPE, null).stringValue;"))
                .trim();
        log.info(genderValue);
        return genderValue;
    }
}