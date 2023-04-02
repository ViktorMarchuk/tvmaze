package com.epam.tvmaze.steps;

import com.epam.tvmaze.service.PeopleApi;
import com.epam.tvmaze.utils.ConfigReaderApiProperties;
import io.restassured.response.Response;

public class ActionsWithPeopleApi{
    String peoplePath = "search/people";
    String correctPersonNameEndpoint = "?q=Sarah Shahi";
    String incorrectPersonNameEndpoint = "?q=&";

    public Response getCorrectNameApi(){
        return PeopleApi.getPersonName(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                peoplePath, correctPersonNameEndpoint);
    }

    public Response getIncorrectNameApi(){
        return PeopleApi.getPersonName(ConfigReaderApiProperties.getValueProperties("config_api", "apiUrl"),
                peoplePath, incorrectPersonNameEndpoint);
    }
}
