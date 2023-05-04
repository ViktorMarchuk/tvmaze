package com.epam.tvmaze.client;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PeopleSearchClient {

  public Response getPersonSearch(String personName) {
    String peopleSearchPath = String.format("/search/people?q=%s", personName);
    log.info(String.format("Request: %s", peopleSearchPath));
    return RestAssured.given()
        .when()
        .get(peopleSearchPath);
  }
}
