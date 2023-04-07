package com.epam.tvmaze.test;

import com.epam.tvmaze.data.DataRequest;
import com.epam.tvmaze.specifications.TVShowValidationService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSearchTest extends BaseTest {

    @Test(description = "API Search test with part of show name", dataProvider = "partOfName", dataProviderClass = DataRequest.class)
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        String url = String.format("/search/shows?q=%s", tvShowPartOfName);
        client.sendGet(url);
        TVShowValidationService tvShowValidationService = new TVShowValidationService(client);

        assertThat(client.getOKStatusCode()).isEqualTo(200);
        assertThat(tvShowValidationService.isResponseContainsPartOfTVShow(tvShowPartOfName))
                .as("Response should contain TV show with name %s", tvShowPartOfName);
        assertThat(tvShowValidationService.isArrayOfShowsValid(client.getBody())).as("Response should be valid").isTrue();
    }
}
