package com.epam.tvmaze.specifications;

import com.epam.tvmaze.utils.ConfigEnum;
import com.epam.tvmaze.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RestClient {
    private Response response;
    private int statusCode;
    private String body;

    public RestClient() {
        RestAssured.baseURI = ConfigReader.getValue(ConfigEnum.API_URL);
    }

    public void sendGet(String url) {
        response = RestAssured.given()
                .when()
                .get(url);
        log.info(String.format("Request: %s", url));
    }

    public int getOKStatusCode() {
        statusCode = response.getStatusCode();
        if (statusCode != 200) {
            log.error(String.format("An error code received. Server returned %d %s",
                    statusCode, response.getStatusLine()));
            throw new RuntimeException(String.format("An error code received. Server returned %d %s",
                    statusCode, response.getStatusLine()));
        }
        log.info(String.format("Status code: %s", statusCode));
        return statusCode;
    }

    public int getNotFoundStatusCode() {
        statusCode = response.getStatusCode();
        if (statusCode != 404) {
            log.error(String.format("An error code received. Server returned %d %s",
                    statusCode, response.getStatusLine()));
            throw new RuntimeException(String.format("An error code received. Server returned %d %s",
                    statusCode, response.getStatusLine()));
        }
        log.info(String.format("Status code: %s", statusCode));
        return statusCode;
    }

    public String getBody() {
        body = response.getBody().asString();
        log.info(String.format("Body is %s", body));
        return body;
    }

    public void closeClient() {
        RestAssured.reset();
    }
}
