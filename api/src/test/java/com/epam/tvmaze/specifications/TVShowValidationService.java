package com.epam.tvmaze.specifications;

import com.epam.tvmaze.pojo.TVShow;
import com.epam.tvmaze.utils.TVShowValidationUtils;

import java.util.List;

public class TVShowValidationService {
    private RestClient restClient;

    public TVShowValidationService(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<TVShow> getTVShows() {
        String body = restClient.getBody();
        return TVShowValidationUtils.createTVShowList(body);
    }

    public boolean isArrayOfShowsValid(String body) {
        return TVShowValidationUtils.isArrayOfShowsValid(body);
    }

    public boolean isValidSingleSearchShowApiResponse(String responseBody) {
        return TVShowValidationUtils.isValidSingleSearchShowApiResponse(responseBody);
    }
}
