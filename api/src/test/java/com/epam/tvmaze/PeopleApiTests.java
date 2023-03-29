package com.epam.tvmaze;

import com.epam.tvmaze.steps.ActionsWithPeopleApi;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

@Log4j2
public class PeopleApiTests{
    ActionsWithPeopleApi actionsWithPeopleApi=new ActionsWithPeopleApi();
    @Test
    public void testCorrectPersonNameWithStatusCode200(){
        Assert.assertEquals(actionsWithPeopleApi.getCorrectNameApi().getStatusCode(),200);
    }
    @Test
    public void testIncorrectPersonNameWithStatus200(){
        Assert.assertEquals(actionsWithPeopleApi.getIncorrectNameApi().getStatusCode(),200);
    }
}
