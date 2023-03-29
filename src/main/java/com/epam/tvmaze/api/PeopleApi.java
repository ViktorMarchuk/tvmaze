package com.epam.tvmaze.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PeopleApi{
    public  Response getPersonName(String url, String endpoint){
        return given()
                .get(url+endpoint);
    }
}
