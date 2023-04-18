package com.epam.tvmaze.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

import com.epam.tvmaze.pages.ShowsPage;
import com.epam.tvmaze.steps.ActionsOnShowsPage;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

@Log4j2
public class ShowsPageTest extends BaseTest {

  ActionsOnShowsPage actionsOnShowsPage = new ActionsOnShowsPage();
  ShowsPage showsPage = new ShowsPage();

  @Test()
  public void testFilterShowsByParameterFollowing() {
    actionsOnShowsPage.actionWithFilterShowsByParameterFollows();
    try {
      assertThat(showsPage.getNameFollowingOnThePageWithFirstChosenMovie().isDisplayed()).isTrue();
    } catch (NoSuchElementException e) {
      log.info("Element /" + showsPage.FOLLOWING + " /not found");
    }
    try {
      assertThat(showsPage.getNameIfThePageDoNotHaveAnyMovieOnPage().isDisplayed()).isTrue();
    } catch (NoSuchElementException e) {
      log.info("Element  /" + showsPage.THERE_ARE_NO_SHOW_ENTRIES_YET + "/ not found");
    }
  }

  @Test
  public void testFilterShowsByParameterRating() {
    actionsOnShowsPage.actionWithFilterShowsByParameterRating();
    log.info("Test with chosen parameter rating 9+");
    try {
      assertTrue(
          showsPage.getMovieRating(
              showsPage.getTextMovieRatingForTestFilterShowsByParameterRating())
              >= 9);
    } catch (NoSuchElementException e) {
      log.info("Element /" + showsPage.FOLLOWING + " /not found ");
    }
    try {
      assertThat(showsPage.getNameIfThePageDoNotHaveAnyMovieOnPage().isDisplayed()).isTrue();
    } catch (NoSuchElementException e) {
      log.info("Element  /" + showsPage.THERE_ARE_NO_SHOW_ENTRIES_YET + "/ not found");
    }
  }

  @Test
  public void testFilterShowsByParameterSortBy() {
    actionsOnShowsPage.actionWithFilterShowByParameterShowBy();
    log.info("Test with chosen parameter following, rating 8+ and sort by A-Z");
    try {
      assertThat(showsPage.getTextWithLabelFollowingOnThePageWithFirstChosenMovie()).isEqualTo(
          showsPage.FOLLOWING);
      assertTrue(
          showsPage.getMovieRating(
              showsPage.getTextMovieRatingForTestFilterShowsByParameterRating())
              >= 8);
    } catch (NoSuchElementException e) {
      log.info("Element /" + showsPage.FOLLOWING + " /not found ");
    }
    try {
      assertThat(showsPage.getNameIfThePageDoNotHaveAnyMovieOnPage().isDisplayed()).isTrue();
    } catch (NoSuchElementException e) {
      log.info("Element  /" + showsPage.THERE_ARE_NO_SHOW_ENTRIES_YET + "/ not found");
    }
  }
}
