package com.epam.tvmaze.specifications;

import com.epam.tvmaze.utils.TVShowValidationUtils;

public class TVShowValidationService {
    private RestClient restClient;

    public TVShowValidationService(RestClient restClient) {
        this.restClient = restClient;
    }

    public boolean isResponseContainsPartOfTVShow(String tvShowPartOfName) {
        return TVShowValidationUtils.isResponseContainsPartOfTVShow(tvShowPartOfName, restClient.getBody());
    }

    public boolean isResponseContainsTVShow(String tvShow) {
        return TVShowValidationUtils.isResponseContainsTVShow(tvShow, restClient.getBody());
    }

    public boolean isArrayOfShowsValid(String body) {
        return TVShowValidationUtils.isArrayOfShowsValid(body);
    }

    public boolean isValidSingleSearchShowApiResponse(String responseBody) {
        return TVShowValidationUtils.isValidSingleSearchShowApiResponse(responseBody);
    }
}
