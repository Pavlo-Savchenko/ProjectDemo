package org.prog.testNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.dto.LocationDto;
import org.example.dto.ResponseDto;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.ResponseCache;

public class RestTest {
    @Test
    public void getRandomUser(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.queryParam("inc","gender,name,nat,location");
        requestSpecification.queryParam("noinfo");
        requestSpecification.queryParam("results",10);
        requestSpecification.baseUri("https://randomuser.me/");
        requestSpecification.basePath("/api");
         Response response =requestSpecification.get();
         response.prettyPrint();
        ResponseDto dto =response.as(ResponseDto.class);
Assert.assertNotNull(dto.getResults().get(0).getLocation());
    }
}
