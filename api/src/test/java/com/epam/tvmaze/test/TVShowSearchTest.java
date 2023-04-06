package com.epam.tvmaze.test;

import com.epam.tvmaze.data.DataRequest;
import com.epam.tvmaze.pojo.TVShow;
import com.epam.tvmaze.specifications.TVShowValidationService;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class TVShowSearchTest extends BaseTest {

    @Test(description = "API Search test with part of show name", dataProvider = "partOfName", dataProviderClass = DataRequest.class)
    public void testGetSearchResponseContainsTVShow(String tvShowPartOfName) {
        String url = String.format("/search/shows?q=%s", tvShowPartOfName);
        client.sendGet(url);

        assertThat(client.getStatusCode()).isEqualTo(200);

        TVShowValidationService tvShowValidationService = new TVShowValidationService(client);
        List<TVShow> tvShowList = tvShowValidationService.getTVShows();

        assertThat(tvShowList)
                .filteredOn(tvShow -> tvShow.getName().contains(tvShowPartOfName))
                .as("Response should contain TV show with name %s", tvShowPartOfName)
                .isNotEmpty();

        assertThat(tvShowValidationService.isArrayOfShowsValid(client.getBody())).as("Response should be valid").isTrue();
    }
}
