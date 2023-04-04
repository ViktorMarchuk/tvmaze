package com.epam.tvmaze;

import com.epam.tvmaze.steps_api.ActionsWithPeopleApi;
import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class PeopleApiTests {
    private final String PEOPLE_PATH = "search/people";

    @Test
    public void testCorrectPersonName() {
        String correctPersonNameEndPoint = "?q=Sarah Shahi";
        Assert.assertEquals(ActionsWithPeopleApi.getNameApi(ConfigReader.getValue(ConfigEnum.API_URL),
                PEOPLE_PATH, correctPersonNameEndPoint).getStatusCode(), 200);
    }

    @Test
    public void testIncorrectPerson() {
        String incorrectPersonNameEndPoint = "?q=&";
        Assert.assertEquals(ActionsWithPeopleApi.getNameApi(ConfigReader.getValue(ConfigEnum.API_URL),
                PEOPLE_PATH, incorrectPersonNameEndPoint).getStatusCode(), 200);
    }
}
