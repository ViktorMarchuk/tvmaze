package com.epam.tvmaze.test;

import com.epam.tvmaze.data.DataRequest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSingleSearchNegativeTest extends BaseTest {
    @Test(description = "API SingleSearch test with incorrect data ", dataProvider = "tvShowNameIncorrect", dataProviderClass = DataRequest.class)
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        String url = String.format("/singlesearch/shows?q=%s", tvShowName);
        String expectedResult = "null";
        client.sendGet(url);

        assertThat(client.getNotFoundStatusCode()).isEqualTo(404);
        assertThat(client.getBody()).isEqualTo(expectedResult);
    }
}
