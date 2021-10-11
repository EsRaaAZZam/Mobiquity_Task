package com.mobiquity_task.utils;

import com.mobiquity_task.model.Comment;
import com.mobiquity_task.tests.BaseTest;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.validator.EmailValidator;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public final class RestAssuredUtil extends BaseTest {

    private RestAssuredUtil() {
    }

    public static String getBaseURI() {
        return "https://jsonplaceholder.typicode.com";
    }

    public static Response fetchFromAPI(String queryParam, Object queryParamValue, String apiPath) throws IOException {
        return given()
                .log().all().spec(requestSpecification())
                .queryParam(queryParam, queryParamValue)
                .when().get(apiPath);
    }

    public static RequestSpecification requestSpecification() throws IOException {

        if (req == null) {
            req = new RequestSpecBuilder().setBaseUri(getBaseURI())
                    .setContentType(ContentType.JSON).build();
        }
        return req;
    }


    public static void checkStatusIs200(Response res) {

        Assert.assertEquals(res.getStatusCode(), 200, "Status Check Failed!");
    }


    public static <T> ArrayList<T> getContent(JsonPath jp) {
        return jp.get();
    }

    //Returns JsonPath object
    public static JsonPath getJsonPath(Response res) {
        String json = res.asString();
        return new JsonPath(json);


    }

    public static void validateEmails(List<Comment> commentList) throws IOException {
        EmailValidator validator = EmailValidator.getInstance();
        for (Comment commentEmail : commentList) {
            Boolean isValidEmailFormatter = true;
            if (!validator.isValid(commentEmail.getEmail())) {
                isValidEmailFormatter = false;
            }
            Assert.assertTrue(isValidEmailFormatter);
        }
    }


}
