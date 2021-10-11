package com.mobiquity_task.tests;

import com.mobiquity_task.utils.RestAssuredUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;


public class BaseTest {


    public static RequestSpecification req;
    public Response resUser = null; //Response
    public Response resPost = null; //Response
    public Response rescomments;
    public JsonPath jp = null; //JsonPath

    @Before
    void setUp() {
        RestAssuredUtil.getBaseURI();
    }
}
