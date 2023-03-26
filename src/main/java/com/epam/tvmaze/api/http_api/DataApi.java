package com.epam.tvmaze.api.http_api;

public class DataApi{
    public final String BASE_URL = "https://api.tvmaze.com/";
    public final String CORRECT_PERSON_NAME_ENDPOINT = "search/people?q=Sarah Shahi";
    public final String INCORRECT_PERSON_NAME_ENDPOINT = "search/people?q=&";
    public final String CORRECT_EPISODE_ENDPOINT = "shows/1/episodebynumber?season=1&number=1";
    public final String INCORRECT_EPISODE_ENDPOINT = "1/episodebynumber?season=1&number=0";
}
