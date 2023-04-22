package com.epam.tvmaze.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class PersonExtractUtils {

  public static String getNameFromUrlByJson(String urlString) {
    URL url = null;
    try {
      url = new URL(urlString);
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }

    StringBuilder sb = new StringBuilder();
    try (BufferedReader in = new BufferedReader(
        new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
        sb.append(inputLine);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = null;
    try {
      jsonNode = objectMapper.readTree(sb.toString());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    if (jsonNode.isArray() && jsonNode.size() > 0) {
      JsonNode firstResult = jsonNode.get(0);
      JsonNode personNode = firstResult.get("person");
      if (personNode != null) {
        String name = personNode.get("name").asText();
        return name;
      }
    }
    return null;
  }
}

