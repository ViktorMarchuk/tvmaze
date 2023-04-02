package com.epam.tvmaze.service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EpisodeApi{
    public static Response getEpisode(String url, String path, String endpoint){
        return given()
                .get(url + path + endpoint);
    }
}
