package com.mobiquity_task.services;

import com.mobiquity_task.model.Comment;
import com.mobiquity_task.model.Post;
import com.mobiquity_task.tests.BaseTest;
import com.mobiquity_task.utils.RestAssuredUtil;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity_task.utils.RestAssuredUtil.fetchFromAPI;
import static com.mobiquity_task.utils.RestAssuredUtil.getContent;


public class APIPostService extends BaseTest implements IPostService{
    @Override
    public  void searchForPostsForUser(String userId) throws IOException {
         resPost = fetchFromAPI("userId" , userId , "/posts");
        RestAssuredUtil.checkStatusIs200(resPost);
        jp = RestAssuredUtil.getJsonPath(resPost);


         // System.out.println(getContent(jp));

    }

    public List fetchAllPostIds() throws IOException {
        Post[] posts;
        List<Post> postsList;
        List<Integer> postsids;

        if (jp.getJsonObject("postId").toString()=="[]") {
            postsids = new ArrayList<>();


        }else {
            posts = resPost.as(Post[].class);
            postsList = new ArrayList<>(Arrays.asList(posts));
            postsids = new ArrayList<>();
            for (Post postid : postsList) {
                postsids.add(postid.getId());
            }
            ////TODO
            // for (Post postid : postsList) {
            //   System.out.println(" post id " + postid.getId());
            // }
            Assert.assertTrue(posts.length > 0);
        }
        return postsids;
    }

    @Override
    public  void isJsonKeyEmpty() throws IOException {

        List<Integer> list = fetchAllPostIds();
        Assert.assertEquals(list.size(), 0);
        for (int postid : list) {

            Assert.assertEquals(java.util.Optional.ofNullable(list.get(postid)), 0);
        }
    }
}
