package com.epam.tvmaze.steps;

import com.epam.tvmaze.service.PeopleApi;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.restassured.response.Response;

public class ActionsWithPeopleApi{
    String peoplePath = "search/people";
    String correctPersonNameEndpoint = "?q=Sarah Shahi";
    String incorrectPersonNameEndpoint = "?q=&";

    public Response getCorrectNameApi(){
        return PeopleApi.getPersonName(ConfigReader.getValue(ConfigEnum.API_URL),
                peoplePath, correctPersonNameEndpoint);
    }

    public Response getIncorrectNameApi(){
        return PeopleApi.getPersonName(ConfigReader.getValue(ConfigEnum.API_URL),
                peoplePath, incorrectPersonNameEndpoint);
    }
}
