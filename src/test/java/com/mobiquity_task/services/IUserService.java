package com.mobiquity_task.services;

import java.io.IOException;

public interface IUserService {
    void searchForUserUsingUsername(String userName) throws IOException;

    String getUserId() throws IOException;

    void isJsonKeyEmpty();

}
