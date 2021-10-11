package com.mobiquity_task.services;

import com.mobiquity_task.tests.BaseTest;
import com.mobiquity_task.utils.RestAssuredUtil;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;

import static com.mobiquity_task.utils.RestAssuredUtil.fetchFromAPI;

public class APIUserService extends BaseTest implements IUserService {
    String userID;
    public void searchForUserUsingUsername(String userName) throws IOException {
         resUser =  fetchFromAPI("username" , userName , "/users");
        RestAssuredUtil.checkStatusIs200(resUser);
        jp = RestAssuredUtil.getJsonPath(resUser);


    }

    public String getUserId() throws IOException {
        //  resUser = requestSpecification().when().get();
        jp = new JsonPath(resUser.asString());
        jp = resUser.jsonPath();
        userID = jp.getJsonObject("id").toString().replace("[", "").replace("]", "");
        System.out.println(userID);
        return userID;
    }

    @Override
    public  void isJsonKeyEmpty() {
        jp = new JsonPath(resUser.asString());
        jp = resUser.jsonPath();
        Assert.assertEquals(("[]"), jp.getJsonObject("username").toString());
    }


}
