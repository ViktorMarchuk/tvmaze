package com.epam.tvmaze.api;

import com.epam.tvmaze.api.apitest.EpisodeApi;
import com.epam.tvmaze.api.http_api.DataApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpisodeApiTests{
    DataApi dataApi = new DataApi();

    @Test
    public void testCorrectEpisode(){
        Response response = EpisodeApi.getEpisode(dataApi.BASE_URL, dataApi.CORRECT_EPISODE);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void testIncorrectEpisode(){
        Response response=EpisodeApi.getEpisode(dataApi.BASE_URL, dataApi.INCORRECT_EPISODE);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),404);
    }
}
