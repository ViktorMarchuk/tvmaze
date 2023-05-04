package com.epam.tvmaze.utils;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonUtils {

  public static JSONObject getJsonFields(String url, int index, String key) {
    JSONArray jsonArray = new JSONArray(url);
    JSONObject jsonObject = jsonArray.getJSONObject(index);
    JSONObject personObject = jsonObject.getJSONObject(key);
    return personObject;
  }
}
