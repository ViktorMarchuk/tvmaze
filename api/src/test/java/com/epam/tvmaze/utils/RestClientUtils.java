package com.epam.tvmaze.utils;

import lombok.extern.log4j.Log4j2;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

@Log4j2
public class RestClientUtils {
    private static List<String> createTVShowNameList(String body) {
        List<String> tvShowList = new ArrayList<>();
        if (body.startsWith("[")) {
            JSONArray jsonArray = new JSONArray(body);
            List<JSONObject> jsonObjectList = new ArrayList<>();
            for (Object jsonObject : jsonArray) {
                jsonObjectList.add(((JSONObject) jsonObject).getJSONObject("show"));
            }
            for (JSONObject jsonObject : jsonObjectList) {
                tvShowList.add(jsonObject.getString("name"));
            }
        } else {
            JSONObject jsonObject = new JSONObject(body);
            tvShowList.add(jsonObject.getString("name"));
        }
        log.info("TVShow names: " + tvShowList);
        return tvShowList;
    }

    public static boolean isResponseContainsTVShow(String tvShow, String body) {
        return createTVShowNameList(body).stream().anyMatch(s -> s.contains(tvShow));
    }
}
