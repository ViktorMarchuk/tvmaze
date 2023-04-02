package com.epam.tvmaze.steps;

import com.epam.tvmaze.service.EpisodeApi;
import com.epam.tvmaze.utils.ConfigReaderApiProperties;
import io.restassured.response.Response;

public class ActionsWithEpisodeApi{
    String episodePath = "shows/1/episodebynumber";
    String correctEpisodeEndpoint = "?season=1&number=1";
    String incorrectEpisodeEndpoint = "?season=1&number=0";

    public Response getCorrectEpisodeApi(){
        return EpisodeApi.getEpisode(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                episodePath, correctEpisodeEndpoint);
    }

    public Response getIncorrectEpisodeApi(){
        return EpisodeApi.getEpisode(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                episodePath, incorrectEpisodeEndpoint);
    }
}
