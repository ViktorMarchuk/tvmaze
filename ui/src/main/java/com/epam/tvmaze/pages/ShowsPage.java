package com.epam.tvmaze.pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ShowsPage extends LoginPage {

    public final String FOLLOWING = "Following";
    public final String THERE_ARE_NO_SHOW_ENTRIES_YET = "There are no Show entries yet.";
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

    public void clickDropDownListFollowing() {
        dropDownListByLabelFollowing.click();
    }

    public void clickNameFollowing() {
        chosenNameFollowing.click();
    }

    public void clickButtonFilter() {
        buttonFilter.click();
    }

    public void clickDropDownListRating() {
        dropDownListByLabelRating.click();
    }

    public void clickChosenRatingByEstimateNine() {
        chosenRatingEstimateNine.click();
    }

    public void clickDropDownListByLabelSortBy() {
        dropDownListByLabelSortBy.click();
    }

    public void clickChosenByLabelSortByAtoZ() {
        chosenByLabelSortByAtoZ.click();
    }

    public void clickChosenRatingByEstimateEighth() {
        chosenByLabelSortByAtoZ.click();
    }

    public void clickLabelFirstMovieOnPageByRating() {
        imageFirstChosenMovieOnPage.click();
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