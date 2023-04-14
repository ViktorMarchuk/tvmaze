package com.epam.tvmaze.utils;

import com.epam.tvmaze.pojo.show.TVShow;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Log4j2
public class RestClientUtils {

    private static List<TVShow> createTVShowList(String body) {
        ObjectMapper mapper = new ObjectMapper();
        List<TVShow> tvShowList = null;

        try {
            if (body.startsWith("[")) {
                tvShowList = mapper.readValue(body, new TypeReference<List<TVShow>>() {
                });
            } else {
                TVShow tvShow = mapper.readValue(body, TVShow.class);
                tvShowList = Collections.singletonList(tvShow);
            }
        } catch (JsonProcessingException e) {
            log.error("Error while processing JSON: " + e.getMessage());
        }

        if (tvShowList == null) {
            tvShowList = new ArrayList<>();
        }

        log.info("TVShow list: " + tvShowList);
        return tvShowList;
    }

    public static boolean isResponseContainsTVShow(String tvShowName, String body) {
        List<TVShow> tvShowList = createTVShowList(body);
        return tvShowList.stream().anyMatch(tvShow -> Objects.equals(tvShow.getName(), tvShowName));
    }

    public static boolean isResponseValid(String body) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(body);
            if (!rootNode.isArray()) {
                return false;
            }
            for (JsonNode node : rootNode) {
                if (!node.has("show")) {
                    return false;
                }
                JsonNode showNode = node.get("show");
                if (!showNode.has("id") || !showNode.has("url") || !showNode.has("name")
                        || !showNode.has("webChannel") || !showNode.has("_links")) {
                    return false;
                }
                JsonNode webChannelNode = showNode.get("webChannel");
                if (webChannelNode != null && !webChannelNode.has("name") && !webChannelNode.isNull() ? true : false) {
                    return false;
                }
                JsonNode linksNode = showNode.get("_links");
                if (linksNode != null) {
                    JsonNode previousEpisodeNode = linksNode.get("previousEpisode");
                    if (previousEpisodeNode != null && !previousEpisodeNode.has("href")) {
                        return false;
                    }
                }
            }
        } catch (JsonProcessingException e) {
            log.error("Error while processing JSON: " + e.getMessage());
            return false;
        }
        return true;
    }
}
