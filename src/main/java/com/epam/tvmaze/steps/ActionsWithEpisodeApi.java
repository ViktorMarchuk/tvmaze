package com.epam.tvmaze.steps;

import com.epam.tvmaze.api.EpisodeApi;
import com.epam.tvmaze.utils.ConfigReaderApiProperties;
import io.restassured.response.Response;

public class ActionsWithEpisodeApi{
    EpisodeApi episodeApi = new EpisodeApi();

    public Response getCorrectEpisodeApi(){
        return episodeApi.getEpisode(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                ConfigReaderApiProperties.getValueProperties("config_api", "correctEpisodeEndpoint"));
    }

    public Response getIncorrectEpisodeApi(){
        return episodeApi.getEpisode(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                ConfigReaderApiProperties.getValueProperties("config_api", "incorrectEpisodeEndpoint"));
    }
}
