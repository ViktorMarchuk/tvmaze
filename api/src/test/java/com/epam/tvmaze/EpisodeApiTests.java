package com.epam.tvmaze;

import com.epam.tvmaze.steps_api.ActionsWithEpisodeApi;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class EpisodeApiTests {
    private final String EPISODE_PATH = "shows/1/episodebynumber";

    @Test
    public void testCorrectEpisodeEndpoint() {
        String correctEpisodeEndPoint = "?season=1&number=1";
        Assert.assertEquals(ActionsWithEpisodeApi.getEpisodeApi(ConfigReader.getValue(ConfigEnum.API_URL),
                EPISODE_PATH, correctEpisodeEndPoint).getStatusCode(), 200);
    }

    @Test
    public void testIncorrectEpisodeEndpoint() {
        String incorrectEpisodeEndpoint = "?season=1&number=0";
        Assert.assertEquals(ActionsWithEpisodeApi.getEpisodeApi(ConfigReader.getValue(ConfigEnum.API_URL),
                EPISODE_PATH, incorrectEpisodeEndpoint).getStatusCode(), 404);
    }
}
