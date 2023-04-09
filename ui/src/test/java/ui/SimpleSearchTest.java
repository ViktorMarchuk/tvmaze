package ui;

import com.epam.tvmaze.pages.HomePage;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

@Log4j2
public class SimpleSearchTest extends BaseTest{
    @Test
    void simpleSearch(){
        HomePage page = new HomePage();

        log.info("Search test");
        String expected = "SEARCH";

        page.inputSearchRequest("Wednesday");

        Assertions.assertThat(page.getSearchResponse()).isEqualTo(expected);
    }
}
