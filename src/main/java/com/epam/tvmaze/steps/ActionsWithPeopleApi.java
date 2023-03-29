package com.epam.tvmaze.steps;

import com.epam.tvmaze.api.PeopleApi;
import com.epam.tvmaze.utils.ConfigReaderApiProperties;
import io.restassured.response.Response;

public class ActionsWithPeopleApi{
    PeopleApi peopleApi = new PeopleApi();

    public Response getCorrectNameApi(){
        return peopleApi.getPersonName(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                ConfigReaderApiProperties.getValueProperties("config_api", "correctPersonNameEndpoint"));
    }

    public Response getIncorrectNameApi(){
        return peopleApi.getPersonName(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                ConfigReaderApiProperties.getValueProperties("config_api", "incorrectPersonNameEndpoint"));
    }
}
