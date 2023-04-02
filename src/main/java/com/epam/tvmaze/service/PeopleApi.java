package com.epam.tvmaze.service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PeopleApi{
    public static Response getPersonName(String url, String path, String endpoint){
        return given()
                .get(url + path + endpoint);
    }
}
