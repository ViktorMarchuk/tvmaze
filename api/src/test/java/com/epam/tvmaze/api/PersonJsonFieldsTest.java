package com.epam.tvmaze.api;

import static org.testng.Assert.assertTrue;

import com.epam.tvmaze.client.PeopleSearchClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.utils.JsonUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PersonJsonFieldsTest extends BaseTest {

  @Test(dataProvider = "peopleList", dataProviderClass = ApiDataRequest.class)
  public void testResponseModelMatch(String name) {
    Response peopleSearchClient = new PeopleSearchClient().getPersonSearch(name);

    assertTrue(JsonUtils.getJsonFields(peopleSearchClient.getBody().asString(), 0, "person").has("id"),
        "JSON response does not contain ID field");
    assertTrue(
        JsonUtils.getJsonFields(peopleSearchClient.getBody().asString(), 0, "person").has("url"),
        "JSON response does not contain URL field");
    assertTrue(
        JsonUtils.getJsonFields(peopleSearchClient.getBody().asString(), 0, "person").has("name"),
        "JSON response does not contain NAME field");
    assertTrue(
        JsonUtils.getJsonFields(peopleSearchClient.getBody().asString(), 0, "person").has("birthday"),
        "JSON response does not contain BIRTHDAY field");
  }
}
