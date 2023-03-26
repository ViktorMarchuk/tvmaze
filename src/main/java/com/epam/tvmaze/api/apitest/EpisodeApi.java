package com.epam.tvmaze.api.apitest;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class EpisodeApi{
    public static Response getEpisode(String url,String endpoint){
        return given()
                .get(url+endpoint);
    }
}
