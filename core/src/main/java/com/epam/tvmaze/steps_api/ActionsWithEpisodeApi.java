package com.epam.tvmaze.steps_api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ActionsWithEpisodeApi {
    public static Response getEpisodeApi(String url, String path, String endPoint){
        return given().get(url + path + endPoint);
    }
}
