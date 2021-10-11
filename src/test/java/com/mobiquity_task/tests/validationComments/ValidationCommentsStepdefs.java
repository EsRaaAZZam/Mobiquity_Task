package com.mobiquity_task.tests.validationComments;

import com.mobiquity_task.model.Comment;
import com.mobiquity_task.services.*;
import com.mobiquity_task.tests.BaseTest;
import com.mobiquity_task.utils.RestAssuredUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ValidationCommentsStepdefs  {


    public IUserService userService = new APIUserService();
    public IPostService postService = new APIPostService();
    public ICommentService commentService = new APICommentService();
    public List<Comment> list;

    @Given("Search for the user with username {string}")
    public void searchForTheUserWithUsername(String arg0) throws IOException {
        userService.searchForUserUsingUsername(arg0);
    }


    @Then("search for all posts by this user")
    public void searchForAllPostsByThisUser() throws IOException {
        String userid = userService.getUserId();
        postService.searchForPostsForUser(userid);

    }

    @Then("For each post, fetch the comments and validate  emails format")
    public void forEachPostFetchTheCommentsAndValidateEmailsFormat() throws IOException {

        List<Comment> list = commentService.getComments(postService.fetchAllPostIds());
        RestAssuredUtil.validateEmails(list);
    }

    @Then("no user should be returned")
    public void noUserShouldBeReturned() throws IOException {
        String userid = userService.getUserId();
        Assert.assertTrue(userid.isEmpty());
        userService.isJsonKeyEmpty();


    }

    @Given("Search for the posts with with Invalid  {string}")
    public void searchForThePostsWithWithInvalid(String arg0) throws IOException {


        postService.searchForPostsForUser(arg0);

    }


    @Then("no posts should be returned")
    public void noPostsShouldBeReturned() throws IOException {
        postService.isJsonKeyEmpty();


    }

    @Then("no comments should be returned")
    public void noCommentsShouldBeReturned() throws IOException {
        commentService.isJsonKeyEmpty(list);


    }


    @Given("user search with invalid {string}")
    public void userSearchWithInvalid(String arg0) throws IOException {
        int postId = Integer.parseInt(arg0);
        List<Integer> postIdList = new ArrayList<>();
        postIdList.add(postId);
        list = commentService.getComments(postIdList);


    }
}
