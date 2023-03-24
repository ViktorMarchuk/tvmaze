package com.epam.tvmaze.ui;

import com.epam.tvmaze.pages.HomePage;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class SimpleSearchTest extends BaseTest {
    HomePage page = new HomePage();

    @Test
    void simpleSearch() {
        log.info("Search test");
        String expected = "SEARCH";

        page.inputSearchRequest("Wednesday");

        Assert.assertEquals(page.getSearchResponse(), expected);
    }
}
