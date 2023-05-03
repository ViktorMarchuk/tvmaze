package com.epam.tvmaze.api;

import static org.testng.Assert.assertTrue;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import com.epam.tvmaze.utils.JsonUtils;
import org.testng.annotations.Test;

public class PersonJsonFieldsTest extends BaseTest{
  @Test(dataProvider = "peopleList", dataProviderClass = ApiDataRequest.class)
  public void testResponseModelMatch(String name) {
    String url = String.format(ConfigReader.getValue(ConfigEnum.API_URL) + "/search/people?q=" +
        name);
    client.sendGet(url);

    assertTrue(JsonUtils.jsonFields(client.getBody(), 0, "person").has("id"),
        "JSON response does not contain ID field");
    assertTrue(JsonUtils.jsonFields(client.getBody(), 0, "person").has("url"),
        "JSON response does not contain URL field");
    assertTrue(JsonUtils.jsonFields(client.getBody(), 0, "person").has("name"),
        "JSON response does not contain NAME field");
    assertTrue(JsonUtils.jsonFields(client.getBody(), 0, "person").has("birthday"),
        "JSON response does not contain BIRTHDAY field");
  }
}
