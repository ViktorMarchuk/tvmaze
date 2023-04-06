package com.epam.tvmaze.test;

import com.epam.tvmaze.data.DataRequest;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class TVShowSearchTest extends BaseTest {

    @Test(description = "API Search test with part of show name", dataProvider = "partOfName", dataProviderClass = DataRequest.class)
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        String url = String.format("/search/shows?q=%s", tvShowPartOfName);
        client.sendGet(url);

        assertThat(client.getOKStatusCode()).isEqualTo(200);
        assertThat(client.isResponseContainsTVShow(tvShowPartOfName))
                .as("Response should contain TV show with name %s", tvShowPartOfName);
        assertThat(client.isResponseValid(client.getBody())).as("Response should be valid").isTrue();
    }
}
