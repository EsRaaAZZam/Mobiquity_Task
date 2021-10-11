package com.mobiquity_task.services;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.List;

public interface IUserService {
      void searchForUserUsingUsername(String userName) throws IOException;
      String getUserId() throws IOException;
      void isJsonKeyEmpty() ;

      }
