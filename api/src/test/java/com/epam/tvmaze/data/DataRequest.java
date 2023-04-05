package com.epam.tvmaze.data;

import org.testng.annotations.DataProvider;

public class DataRequest {
    @DataProvider(name = "partOfName")
    public static Object[][] providePartOfTVShowName() {
        return new Object[][]{
                {"Wednesday"},
                {"Hamlet"},
                {"Downtown"}
        };
    }
}
