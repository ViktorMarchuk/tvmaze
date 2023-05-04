package com.epam.tvmaze.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tvmaze.client.PeopleSearchClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.utils.PersonExtractUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class SearchByPeopleNegativeTest extends BaseTest {

  @Test(dataProvider = "incorrectPeopleList", dataProviderClass = ApiDataRequest.class)
  public void testGetResponseByIncorrectPeopleNameLastName(String name) {
    Response peopleSearchClient = new PeopleSearchClient().getPersonSearch(name);

    assertThat(peopleSearchClient.getStatusCode()).isEqualTo(200);
    assertThat(PersonExtractUtils.getPersonList(peopleSearchClient.getBody().asString())).isNullOrEmpty();
  }
}
