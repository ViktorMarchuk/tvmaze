package com.epam.tvmaze.steps_ui;

import com.epam.tvmaze.pages.ShowsPage;

public class ActionsOnShowsPage extends ShowsPage{
    public void actionWithFilterShowsByParameterFollows(){
        openPage();
        clickFieldLogin();
        inputUserName();
        inputPassword();
        clickButtonLogin();
        clickLabelShows();
        clickDropDownListFollowing();
        clickNameFollowing();
        clickButtonFilter();
    }

    public void actionWithFilterShowsByParameterRating(){
        openPage();
        clickLabelShows();
        clickDropDownListRating();
        clickChosenRatingByEstimateNine();
        clickButtonFilter();
    }

    public void actionWithFilterShowByParameterShowBy(){
        openPage();
        clickLabelShows();
        clickDropDownListFollowing();
        clickNameFollowing();
        clickDropDownListRating();
        clickChosenRatingByEstimateEighth();
        clickDropDownListByLabelSortBy();
        clickChosenByLabelSortByAtoZ();
        clickButtonFilter();
    }
}

