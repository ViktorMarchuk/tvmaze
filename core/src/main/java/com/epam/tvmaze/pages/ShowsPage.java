package com.epam.tvmaze.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShowsPage extends HomePage{
    @FindBy(id = "show-following")
    private WebElement dropDownListByLabelFollowing;
    @FindBy(xpath = "//select[@id='show-following']/option[3]")
    private WebElement chosenNameFollowing;
    @FindBy(xpath = "//form[@id='w0']/div[12]/button")
    private WebElement buttonFilter;
    @FindBy(id = "show-rating")
    private WebElement dropDownListByLabelRating;
    @FindBy(xpath = "//select[@id='show-rating']/option[9]")
    private WebElement chosenRatingEstimateNine;
    @FindBy(xpath = "//select[@id='show-rating']/option[8]")
    private WebElement chosenRatingEstimateEighth;
    @FindBy(id = "show-sort")
    private WebElement dropDownListByLabelSortBy;
    @FindBy(xpath = "//*[@id='show-sort']/option[5]")
    private WebElement chosenByLabelSortByAtoZ;

    public void clickDropDownListFollowing(){
        dropDownListByLabelFollowing.click();
    }

    public void clickNameFollowing(){
        chosenNameFollowing.click();
    }

    public void clickButtonFilter(){
        buttonFilter.click();
    }

    public void clickDropDownListRating(){
        dropDownListByLabelRating.click();
    }

    public void clickChosenRatingByEstimateNine(){
        chosenRatingEstimateNine.click();
    }

    public void clickDropDownListByLabelSortBy(){
        dropDownListByLabelSortBy.click();
    }

    public void clickChosenByLabelSortByAtoZ(){
        chosenByLabelSortByAtoZ.click();
    }

    public void clickChosenRatingByEstimateEighth(){
        chosenByLabelSortByAtoZ.click();
    }
}
