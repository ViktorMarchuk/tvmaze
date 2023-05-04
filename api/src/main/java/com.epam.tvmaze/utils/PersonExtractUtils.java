package com.epam.tvmaze.utils;

import com.epam.tvmaze.pojo.person.Person;
import com.epam.tvmaze.pojo.person.SearchPeople;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonExtractUtils {

  public static List<Person> getPersonList(String body) {
    ObjectMapper mapper = new ObjectMapper();
    List<Person> personList = new ArrayList<>();
    try {
      List<SearchPeople> searchResultList = mapper.readValue(body,
          new TypeReference<List<SearchPeople>>() {
          });
      for (SearchPeople searchResult : searchResultList) {
        Person person = searchResult.getPerson();
        if (person != null && person.getId() != 0) {
          personList.add(person);
        } else {
          log.warn("Unable to parse Person object: " + searchResult);
        }
      }
    } catch (JsonProcessingException e) {
      log.error("Error while processing JSON: " + e.getMessage());
    }
    log.info(String.format("Person list: %s", personList));
    return personList;
  }
}

