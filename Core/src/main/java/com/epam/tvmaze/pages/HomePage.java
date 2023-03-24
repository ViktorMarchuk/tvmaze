package com.epam.tvmaze.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log4j2
public class HomePage extends AbstractPage {
    @FindBy(id = "searchform-q")
    private WebElement inputSearch;
    @FindBy(xpath = "//li[@class='current']//span[contains(@itemprop,'title')]")
    private WebElement labelSearch;

    public HomePage inputSearchRequest(String searchRequest) {
        inputSearch.clear();
        inputSearch.sendKeys(searchRequest, Keys.ENTER);
        log.info(String.format("Entered request - %s", searchRequest));
        return this;
    }

    public String getSearchResponse() {
        String searchTitle = labelSearch.getText();
        return searchTitle;
    }
}
