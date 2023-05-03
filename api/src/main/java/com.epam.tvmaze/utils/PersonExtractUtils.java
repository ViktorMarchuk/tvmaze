package com.epam.tvmaze.utils;

import com.epam.tvmaze.pojo.person.SearchPeople;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonExtractUtils {

  public static String getPersonName(String json) {
    ObjectMapper objectMapper = new ObjectMapper();
    SearchPeople[] searchPeople = null;
    try {
      searchPeople = objectMapper.readValue(json, SearchPeople[].class);
    } catch (JsonProcessingException e) {
      log.error("Error while processing JSON: ", e.getMessage());
    }
    if (searchPeople != null && searchPeople.length > 0 && searchPeople[0].getPerson() != null) {
      String name = searchPeople[0].getPerson().getName();
      return name;
    }
    return null;
  }
}

