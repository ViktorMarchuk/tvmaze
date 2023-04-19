package com.epam.tvmaze.ui;

import com.epam.tvmaze.pages.HomePage;
import com.epam.tvmaze.pages.ShowsPage;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class ShowsPageTest extends BaseTest {
    private final String FOLLOWING = "Following";
    private ShowsPage showsPage;

    @BeforeMethod
    @Override
    public void beforeTest() {
        homePage = new HomePage().openPage();
    }

    @Test
    public void testFilterShowsByParameterRating() {
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListRating()
                .clickChosenRatingByEstimateNine()
                .clickButtonFilter()
                .clickLabelFirstMovieOnPageByRating();

        assertThat(showsPage.getMovieRating(showsPage.getTextMovieRatingForTestFilterShowsByParameterRating()))
                .withFailMessage("Element /" + FOLLOWING + " /not found ")
                .isGreaterThanOrEqualTo(9);
    }

    @Test
    public void testFilterShowsByParameterFollowing() {
        homePage.clickLinkLogin().inputUserName().inputPassword().clickButtonLogin();
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListFollowing()
                .clickNameFollowing()
                .clickButtonFilter()
                .clickLabelFirstMovieOnPageByRating();

        assertThat(showsPage.getNameFollowingOnThePageWithFirstChosenMovie().isDisplayed())
                .withFailMessage("Element /" + FOLLOWING + " /not found")
                .isTrue();
    }

    @Test
    public void testFilterShowsByParameterSortBy() {
        homePage.clickLinkLogin().inputUserName().inputPassword().clickButtonLogin();
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListFollowing()
                .clickNameFollowing()
                .clickDropDownListRating()
                .clickChosenRatingByEstimateEighth()
                .clickDropDownListByLabelSortBy()
                .clickChosenByLabelSortByAtoZ()
                .clickButtonFilter()
                .clickLabelFirstMovieOnPageByRating();

        assertThat(showsPage.getTextWithLabelFollowingOnThePageWithFirstChosenMovie())
                .isEqualTo(FOLLOWING);

        assertThat(showsPage.getMovieRating(showsPage.getTextMovieRatingForTestFilterShowsByParameterRating()))
                .withFailMessage("Element /" + FOLLOWING + " /not found ")
                .isGreaterThanOrEqualTo(8);
    }
}
