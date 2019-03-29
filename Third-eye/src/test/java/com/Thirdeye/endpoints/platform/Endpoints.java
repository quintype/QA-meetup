package com.Thirdeye.endpoints.platform;

import com.Thirdeye.config.ConfigFile;
import com.Thirdeye.utils.SetUp;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class Endpoints {


    @SuppressWarnings("rawtypes")
	public static Map getconfiguration(int responseCode) {

        ConfigFile configObject = SetUp.getConfigObject();
        String endPoint = configObject.sketchesURL + "/api/v1/config";//+ DataAndTimeUtilities.getCurrentDateAndTime();
        Map response = given().log().ifValidationFails().header("Content-Type", "application/json")
                .when().get(endPoint)
                .then().assertThat().statusCode(responseCode).extract().as(Map.class);

        return response;
    }

    public static Map postRequest( int responseCode, String jsonBody) {
        ConfigFile configObject = SetUp.getConfigObject();
        String endPoint = configObject.URL2;
        Map response = given().log().ifValidationFails().header("Content-Type", "application/json")
                .body(jsonBody)
                .when().post(endPoint)
                .then().assertThat().statusCode(responseCode).extract().as(Map.class);

        return response;
    }
}


