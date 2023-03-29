package com.epam.tvmaze;

import com.epam.tvmaze.steps.ActionsWithEpisodeApi;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class EpisodeApiTests{
    ActionsWithEpisodeApi actionsWithEpisodeApi = new ActionsWithEpisodeApi();

    @Test
    public void testCorrectEpisodeWithStatusCode200(){
        Assert.assertEquals(actionsWithEpisodeApi.getCorrectEpisodeApi().getStatusCode(), 200);
    }

    @Test
    public void testIncorrectEpisodeWithStatusCode404(){
        Assert.assertEquals(actionsWithEpisodeApi.getIncorrectEpisodeApi().getStatusCode(), 404);
    }
}
