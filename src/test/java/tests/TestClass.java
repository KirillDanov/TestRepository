package tests;

import api.ApiMethods;
import api.Specifications;
import enums.Enums;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.NewPost;
import models.PostResponse;
import models.User;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DataUtility;
import utilities.JsonUtility;

public class TestClass extends BaseTestClass {
  final String URL = DataUtility.getBasicUrl();

  @Test(testName = "Post order test")
  public void checkPostOrder() {
    Specifications.installSpecifications(
        Specifications.getRequestSpec(URL, ContentType.JSON),
        Specifications.getResponseSpec(HttpStatus.SC_OK, ContentType.JSON));
    Response allPosts = ApiMethods.getAllPosts();
    Assert.assertEquals(
        allPosts.getStatusCode(),
        HttpStatus.SC_OK,
        String.format("Status code is not %s", HttpStatus.SC_OK));
    Assert.assertEquals(
        allPosts.getContentType(),
        String.format("%s; charset=utf-8", ContentType.JSON),
        "ContentType is not JSON");
    Assert.assertTrue(ApiMethods.arePostsSortedById(allPosts), "Posts aren`t sorted by ID");
  }

  @Test(testName = "Check post by number")
  public void testPostByNumber() {
    Specifications.installSpecifications(
        Specifications.getRequestSpec(URL, ContentType.JSON),
        Specifications.getResponseSpec(HttpStatus.SC_OK, ContentType.JSON));
    int postId = DataUtility.getPostId();
    int userId = DataUtility.getUserId();
    Response post = ApiMethods.getPostById(postId);
    PostResponse postModel = post.as(PostResponse.class);
    Assert.assertEquals(postModel.getId(), postId, String.format("Post ID isn`t %s", postId));
    Assert.assertEquals(postModel.getUserId(), userId, String.format("User ID isn`t %s", userId));
    Assert.assertFalse(postModel.getTitle().isEmpty(), "Post title is empty");
    Assert.assertFalse(postModel.getBody().isEmpty(), "Post body is empty");
  }

  @Test(testName = "Check non - existent post")
  public void nonExistentPostTest() {
    Specifications.installSpecifications(
        Specifications.getRequestSpec(URL, ContentType.JSON),
        Specifications.getResponseSpec(HttpStatus.SC_NOT_FOUND, ContentType.JSON));
    Response post = ApiMethods.getPostById(DataUtility.getPostIdNotFound());
    Assert.assertEquals(
        post.statusCode(),
        HttpStatus.SC_NOT_FOUND,
        String.format("Status code is not %s", HttpStatus.SC_NOT_FOUND));
    Assert.assertEquals(post.getBody().asString(), "{}", "Body is not empty");
  }

  @Test(testName = "Test new post")
  public void createPostTest() {
    Specifications.installSpecifications(
        Specifications.getRequestSpec(URL, ContentType.JSON),
        Specifications.getResponseSpec(HttpStatus.SC_CREATED, ContentType.JSON));
    NewPost newPostModel = DataUtility.getTestPost();
    Response newPost = ApiMethods.sendPost(newPostModel);
    PostResponse postResponse = newPost.as(PostResponse.class);
    Assert.assertEquals(
        newPostModel.getBody(),
        postResponse.getBody(),
        "Body in response is not equal to sent post");
    Assert.assertEquals(
        newPostModel.getTitle(),
        postResponse.getTitle(),
        "Title in response is not equal to sent post");
    Assert.assertEquals(
        newPostModel.getUserId(),
        postResponse.getUserId(),
        "User id in response is not equal to sent post");
    Assert.assertFalse(postResponse.getId().toString().isEmpty(), "Id is empty");
  }

  @Test(testName = "User from DataBase test")
  public void userCheck() {
    Specifications.installSpecifications(
        Specifications.getRequestSpec(URL, ContentType.JSON),
        Specifications.getResponseSpec(HttpStatus.SC_OK, ContentType.JSON));
    Response allUsers = ApiMethods.getAllUsers();
    User user = ApiMethods.getUserByIdFromResponse(allUsers, DataUtility.getUserIdForModel());
    User testUser =
        JsonUtility.getModelFromJson(
            DataUtility.getTestUserPath(), User.class, Enums.ROOT_NODE.getString());
    Assert.assertEquals(testUser, user, "User from response is not equal to test data");
  }
}
