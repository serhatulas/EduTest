package org.KeyPoint.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class APIUtils {
    public static String getAccessToken(String email, String password,String endPoint){
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("email", email);
        requestMap.put("password", password);

        Response response = given().contentType(ContentType.JSON)
                .body(requestMap).when().post(ConfigurationReader.get("url_api")+endPoint);

        String token = response.path("data.token");

        String finalToken = "Bearer "+ token;
        System.out.println("finalToken = " + finalToken);

        return finalToken;
    }
}
