package com.epam.tvmaze.test;

import com.epam.tvmaze.data.DataRequest;
import com.epam.tvmaze.specifications.TVShowValidationService;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TVShowSingleSearchValidTest extends BaseTest {
    @Test(description = "API SingleSearch test with valid data ", dataProvider = "tvShowNameValid", dataProviderClass = DataRequest.class)
    public void testGetSingleSearchResponseContainsShow(String tvShowName) {
        String url = String.format("/singlesearch/shows?q=%s", tvShowName);
        client.sendGet(url);
        TVShowValidationService tvShowValidationService = new TVShowValidationService(client);

        assertThat(client.getOKStatusCode()).isEqualTo(200);
        assertThat(tvShowValidationService.isResponseContainsTVShow(tvShowName))
                .as("Response should contain TV show with name %s", tvShowName);
        assertThat(tvShowValidationService.isValidSingleSearchShowApiResponse(client.getBody()))
                .as("Response should be valid").isTrue();
    }
}
