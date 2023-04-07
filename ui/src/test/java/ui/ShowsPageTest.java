package ui;

import com.epam.tvmaze.steps_ui.ActionsOnShowsPage;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Log4j2
public class ShowsPageTest extends BaseTest{
    ActionsOnShowsPage actionsOnShowsPage = new ActionsOnShowsPage();
    String xPathForDataArray = "//div[@id='w1']";

    @Test
    public void testFilterShowsByParameterFollowing(){
        actionsOnShowsPage.actionWithFilterShowsByParameterFollows();
        List <String> expected = Arrays.asList("The Mandalorian  The Blacklist  Wednesday");

        Assertions.assertThat(actionsOnShowsPage.getTextFromArrayXpath(xPathForDataArray)).isEqualTo(expected);
    }

    @Test
    public void testFilterShowsByParameterRating(){
        List <String> expected = Arrays.asList("Game of Thrones  Breaking Bad  Firefly  One Piece  Chernobyl  The World at War  Hajime no Ippo");
        actionsOnShowsPage.actionWithFilterShowsByParameterRating();

        Assertions.assertThat(actionsOnShowsPage.getTextFromArrayXpath(xPathForDataArray)).isEqualTo(expected);
    }

    @Test
    public void testFilterShowsByParameterSortBy(){
        List <String> expected = Arrays.asList("The Blacklist  The Mandalorian  Wednesday");
        actionsOnShowsPage.actionWithFilterShowByParameterShowBy();

        Assertions.assertThat(actionsOnShowsPage.getTextFromArrayXpath(xPathForDataArray)).isEqualTo(expected);
    }
}
