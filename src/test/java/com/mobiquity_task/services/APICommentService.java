package com.mobiquity_task.services;

import com.mobiquity_task.model.Comment;
import com.mobiquity_task.tests.BaseTest;
import com.mobiquity_task.utils.RestAssuredUtil;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity_task.utils.RestAssuredUtil.fetchFromAPI;

public class APICommentService extends BaseTest implements ICommentService {
    @Override
    public List<Comment> getComments(List<Integer> postsidslist) throws IOException {
        List<Comment> allComments = new ArrayList<>();
        for (int postId : postsidslist) {
            Comment[] comments;
            Response response = fetchFromAPI("postId", postId, "/comments");
            comments = response.as(Comment[].class);
            allComments.addAll(Arrays.asList(comments));
            RestAssuredUtil.checkStatusIs200(response);
        }
        return allComments;
    }

    @Override
    public void isJsonKeyEmpty(List<Comment> list) throws IOException {
        Assert.assertEquals(list.size(), 0);

        for (Comment comment : list) {

            Assert.assertEquals(java.util.Optional.ofNullable(comment.getId()), 0);
        }
    }


}
