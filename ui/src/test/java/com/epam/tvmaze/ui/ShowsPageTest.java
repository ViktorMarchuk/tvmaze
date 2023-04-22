package com.epam.tvmaze.ui;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tvmaze.pages.ShowsPage;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class ShowsPageTest extends BaseTest {

    private ShowsPage showsPage;

    @Test(description = "Testing by parameter Rating 9+")
    public void testFilterShowsByParameterRating() {
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListRating()
            .clickChosenRatingByEstimateNine()
            .clickButtonFilter();

        assertThat(showsPage.getRatingList(showsPage.getXpathForRatingList()).stream()
            .allMatch(r -> r >= 9)).withFailMessage("Not found movies with rating 9+");
    }

    @SneakyThrows
    @Test
    public void testFilterShowsByParameterFollowing() {
        homePage.clickLinkLogin()
            .inputUserName()
            .inputPassword()
            .clickButtonLogin();
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListFollowing()
            .clickNameFollowing()
            .clickButtonFilter();

        assertThat(showsPage.getIconWithShapeHeartMatchesNameFollowing().isDisplayed())
            .withFailMessage("Not found movies after choosing by parameter Following")
            .isTrue();

        /**Only this can help, since there is a restriction on sending requests for a registered user **/
        TimeUnit.SECONDS.sleep(8);
    }

    @Test(description = "Testing by parameters Rating 8+, Following and Sort by A to Z")
    public void testFilterShowsByParameterSortBy() {
        homePage.clickLinkLogin()
            .inputUserName()
            .inputPassword()
            .clickButtonLogin();
        showsPage = homePage.clickLinkShows();
        showsPage.clickDropDownListFollowing()
            .clickNameFollowing()
            .clickDropDownListRating()
            .clickChosenRatingByEstimateEighth()
            .clickDropDownListByLabelSortBy()
            .clickChosenByLabelSortByAtoZ()
            .clickButtonFilter();

        assertThat(showsPage.getIconWithShapeHeartMatchesNameFollowing().isDisplayed());
        assertThat(showsPage.getRatingList(showsPage.getXpathForRatingList()).stream()
            .allMatch(r -> r >= 8)).withFailMessage(
            "Not found movies after choosing by parameter Following, Rating 8+ and sort by A to Z) ");
    }
}
