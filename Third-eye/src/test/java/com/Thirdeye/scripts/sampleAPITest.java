package com.Thirdeye.scripts;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.given;

public class sampleAPITest {


 @Test()
	public void getconfiguration() {

        String endPoint =  "https://thequint.com/api/v1/config";
        given()
                .when().get(endPoint)
                .then().assertThat().statusCode(200);

    }
}


