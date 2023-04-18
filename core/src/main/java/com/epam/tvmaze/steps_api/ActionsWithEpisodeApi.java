package com.epam.tvmaze.steps_api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class ActionsWithEpisodeApi {

  public static Response getEpisodeApi(String url, String path, String endPoint) {
    return given().get(url + path + endPoint);
  }
}
