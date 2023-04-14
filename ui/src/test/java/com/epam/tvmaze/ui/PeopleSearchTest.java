package com.epam.tvmaze.ui;

import com.epam.tvmaze.data.UIDataRequest;
import com.epam.tvmaze.pages.PeoplePage;
import com.epam.tvmaze.pojo.person.Person;
import com.epam.tvmaze.specifications.PersonAPIHandler;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PeopleSearchTest extends BaseTest {
    @Test(description = "UI peopleSearch test with valid data", dataProvider = "Search people by valid data",
            dataProviderClass = UIDataRequest.class)
    public void peopleSearch(String peopleNameAndSurname) {
        PeoplePage peoplePage = new PeoplePage();
        peoplePage.inputSearchRequest(peopleNameAndSurname).clickLinkPerson();

        PersonAPIHandler personAPIHandler = new PersonAPIHandler();
        Person apiPerson = personAPIHandler.getAPIPerson(peopleNameAndSurname);

        log.info("Search people test");
        assertThat(apiPerson)
                .isNotNull()
                .withFailMessage("Object apiPerson is null");

        log.info("apiPerson consist of : " + apiPerson);

        assertThat(peoplePage.getNameAndSurname())
                .isEqualTo(apiPerson.getName());

        assertThat(peoplePage.getUrl())
                .isEqualTo(apiPerson.getUrl());

        assertThat(peoplePage.getCountryName())
                .isEqualTo(String.valueOf(apiPerson.getCountry().getName()));

        assertThat(peoplePage.getPersonBirthday())
                .isEqualTo(apiPerson.getBirthday());

        assertThat(peoplePage.getPersonGender())
                .isEqualTo(apiPerson.getGender());
    }
}
