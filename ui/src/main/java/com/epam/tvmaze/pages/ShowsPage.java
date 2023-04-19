package com.epam.tvmaze.pages;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ShowsPage extends HomePage {

    @FindBy(id = "show-following")
    private WebElement dropDownListByLabelFollowing;
    @FindBy(xpath = "//select[@id='show-following']//option[@value='1']")
    private WebElement chosenNameFollowing;
    @FindBy(xpath = "//form[@id='w0']//button[@class='button round']")
    private WebElement buttonFilter;
    @FindBy(id = "show-rating")
    private WebElement dropDownListByLabelRating;
    @FindBy(xpath = "//select[@id='show-rating']//option[@value='90']")
    private WebElement chosenRatingEstimateNine;
    @FindBy(xpath = "//select[@id='show-rating']//option[@value='80']")
    private WebElement chosenRatingEstimateEighth;
    @FindBy(id = "show-sort")
    private WebElement dropDownListByLabelSortBy;
    @FindBy(xpath = "//select[@id='show-sort']//option[@value='3']")
    private WebElement chosenByLabelSortByAtoZ;
    @FindBy(xpath = "//div[@id='w1']/div[1]")
    private WebElement imageFirstChosenMovieOnPage;
    @FindBy(xpath = "//section[@id='general-info-panel']//b[@itemprop='ratingValue']")
    private WebElement movieRatingOnThePageWithFirstChosenMovie;
    @FindBy(xpath = "//div[@id='following']//span[contains(text(),'Following')]")
    private WebElement nameFollowingOnThePageWithFirstChosenMovie;
    @FindBy(xpath = "//div[@id='w1']/div")
    private WebElement nameIfThePageDoNotHaveAnyMovieOnPage;

    @Override
    public ShowsPage openPage() {
        driver.navigate().to(ConfigReader.getValue(ConfigEnum.BASE_URL));
        return this;
    }

    public ShowsPage clickDropDownListFollowing() {
        dropDownListByLabelFollowing.click();
        return this;
    }

    public ShowsPage clickNameFollowing() {
        chosenNameFollowing.click();
        return this;
    }

    public ShowsPage clickButtonFilter() {
        buttonFilter.click();
        return this;
    }

    public ShowsPage clickDropDownListRating() {
        dropDownListByLabelRating.click();
        return this;
    }

    public ShowsPage clickChosenRatingByEstimateNine() {
        chosenRatingEstimateNine.click();
        return this;
    }

    public ShowsPage clickDropDownListByLabelSortBy() {
        dropDownListByLabelSortBy.click();
        return this;
    }

    public ShowsPage clickChosenByLabelSortByAtoZ() {
        chosenByLabelSortByAtoZ.click();
        return this;
    }

    public ShowsPage clickChosenRatingByEstimateEighth() {
        chosenByLabelSortByAtoZ.click();
        return this;
    }

    public ShowsPage clickLabelFirstMovieOnPageByRating() {
        imageFirstChosenMovieOnPage.click();
        return this;
    }

    public String getTextMovieRatingForTestFilterShowsByParameterRating() {
        return movieRatingOnThePageWithFirstChosenMovie.getText();
    }

    public String getTextWithLabelFollowingOnThePageWithFirstChosenMovie() {
        return nameFollowingOnThePageWithFirstChosenMovie.getText();
    }

    public double getMovieRating(String s) {
        double value = Double.parseDouble(s);
        return value;
    }
}