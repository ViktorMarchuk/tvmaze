package com.epam.tvmaze.api;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tvmaze.data.ApiDataRequest;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import com.epam.tvmaze.utils.PersonExtractUtils;
import org.testng.annotations.Test;

public class SearchByPeoplePositiveTest extends BaseTest {

  @Test(dataProvider = "peopleList", dataProviderClass = ApiDataRequest.class)
  public void testGetSearchResponseByCorrectNameLastName(String name) {
    String url = String.format(ConfigReader.getValue(ConfigEnum.API_URL) + "/search/people?q=" +
        name);
    client.sendGet(url);

    assertThat(client.getStatusCode()).isEqualTo(200);
    assertThat(PersonExtractUtils.getPersonName(client.getBody())).isEqualTo(name);
  }
}
