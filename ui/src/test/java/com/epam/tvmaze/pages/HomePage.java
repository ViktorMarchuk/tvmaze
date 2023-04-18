package com.epam.tvmaze.pages;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
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
  @FindBy(xpath = "//div[@id='header-menu']//a[@href='/shows']")
  private WebElement labelShows;

  public HomePage openPage() {
    driver.navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
    return this;
  }

  public HomePage inputSearchRequest(String searchRequest) {
    inputSearch.clear();
    inputSearch.sendKeys(searchRequest, Keys.ENTER);
    log.info(String.format("Entered request - %s", searchRequest));
    return this;
  }

  public String getSearchResponse() {
    return labelSearch.getText();
  }

  public void clickLabelShows() {
    labelShows.click();
  }
}
