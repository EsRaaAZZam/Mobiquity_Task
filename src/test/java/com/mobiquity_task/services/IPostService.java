package com.mobiquity_task.services;

import java.io.IOException;
import java.util.List;

public interface IPostService {
     void searchForPostsForUser(String userId) throws IOException;
     List fetchAllPostIds() throws IOException;
     void isJsonKeyEmpty() throws IOException;

}
