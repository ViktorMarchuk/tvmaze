package com.epam.tvmaze.steps;

import com.epam.tvmaze.service.EpisodeApi;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.restassured.response.Response;

public class ActionsWithEpisodeApi{
    String episodePath = "shows/1/episodebynumber";
    String correctEpisodeEndpoint = "?season=1&number=1";
    String incorrectEpisodeEndpoint = "?season=1&number=0";

    public Response getCorrectEpisodeApi(){
        return EpisodeApi.getEpisode(ConfigReader.getValue(ConfigEnum.API_URL),
                episodePath, correctEpisodeEndpoint);
    }

    public Response getIncorrectEpisodeApi(){
        return EpisodeApi.getEpisode(ConfigReader.getValue(ConfigEnum.API_URL),
                episodePath, incorrectEpisodeEndpoint);
    }
}
