package api;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import java.util.List;
import models.NewPost;
import models.PostResponse;
import models.User;
import utilities.DataUtility;

public class ApiMethods {

  public static Response sendGetRequest(String endpoint) {
    return given().get(endpoint);
  }

  public static <T> Response getPostResponse(String endpoint, T body) {
    return given().body(body).post(endpoint);
  }

  public static Response getAllPosts() {
    return ApiMethods.sendGetRequest(DataUtility.getPostsEndpoint());
  }

  public static Response getPostById(int numPost) {
    return ApiMethods.sendGetRequest(
        String.format("%s/%s", DataUtility.getPostsEndpoint(), numPost));
  }

  public static Response sendPost(NewPost testPost) {
    return ApiMethods.getPostResponse(DataUtility.getPostsEndpoint(), testPost);
  }

  public static boolean arePostsSortedById(Response response) {
    List<PostResponse> postsList = response.jsonPath().getList(".", PostResponse.class);
    List<Integer> postsIds = postsList.stream().map(PostResponse::getId).toList();
    List<Integer> sortedPostIds = postsIds.stream().sorted().toList();
    return postsIds.equals(sortedPostIds);
  }

  public static Response getAllUsers() {
    return ApiMethods.sendGetRequest(DataUtility.getUsersEndpoint());
  }

  public static User getUserByIdFromResponse(Response response, int requiredId) {
    List<User> userList = response.jsonPath().getList(".", User.class);
    return userList.stream().filter(user -> user.getId() == requiredId).findFirst().orElse(null);
  }
}
