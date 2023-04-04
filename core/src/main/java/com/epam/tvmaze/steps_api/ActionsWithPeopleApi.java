package com.epam.tvmaze.steps_api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ActionsWithPeopleApi {
    public static Response getNameApi(String url, String path, String endPoint){
        return given().get(url + path + endPoint);
    }
}