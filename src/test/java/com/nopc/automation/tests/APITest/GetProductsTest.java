package com.nopc.automation.tests.APITest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetProductsTest {
    @Test(description = "Verify all products can be retrieved from Fake Store API")
    public void getAllProducts(){
        RestAssured.useRelaxedHTTPSValidation();
        Response response=given().baseUri("https://fakestoreapi.com").when().get("/products").then().extract().response();
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200,"Status code mismatch");

        int productCount=response.jsonPath().getList("$").size();
        System.out.println("Total products: "+productCount);
        Assert.assertTrue(productCount>0,"No products returned from API");
    }
}
