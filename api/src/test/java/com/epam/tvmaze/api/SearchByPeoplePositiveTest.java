package com.epam.tvmaze.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tvmaze.client.PeopleSearchClient;
import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.pojo.person.Person;
import com.epam.tvmaze.utils.PersonExtractUtils;
import io.restassured.response.Response;
import java.util.List;
import org.testng.annotations.Test;

public class SearchByPeoplePositiveTest extends BaseTest {

  @Test(dataProvider = "peopleList", dataProviderClass = ApiDataRequest.class)
  public void testGetSearchResponseByCorrectNameLastName(String name) {
    Response peopleSearchClient=new PeopleSearchClient().getPersonSearch(name);
    List<Person>personList=PersonExtractUtils.getPersonList(peopleSearchClient.getBody().asString());

    assertThat(peopleSearchClient.getStatusCode()).isEqualTo(200);
    assertThat(personList.stream().filter(person ->person.getName().contains(name)));
  }
}
