package com.epam.tvmaze.api;

import com.epam.tvmaze.api.apitest.PeopleApi;
import com.epam.tvmaze.api.http_api.DataApi;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PeopleApiTests{
    DataApi dataApi=new DataApi();
    @Test
    public void testCorrectPersonName(){
        Response response= PeopleApi.getPersonName(dataApi.BASE_URL ,dataApi.CORRECT_PERSON_NAME_ENDPOINT);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
    @Test
    public void incorrectPersonName(){
        Response response=PeopleApi.getPersonName(dataApi.BASE_URL,dataApi.INCORRECT_PERSON_NAME_ENDPOINT);
        response.prettyPrint();
        Assert.assertEquals(response.getStatusCode(),200);
    }
}
