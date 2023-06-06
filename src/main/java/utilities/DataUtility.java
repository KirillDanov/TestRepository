package utilities;

import static enums.Enums.RESOURCES_PATH;

import models.PostModel;
import org.apache.commons.lang3.RandomStringUtils;

public class DataUtility {

  static final String TEST_DATA_PATH = "src/main/resources/testData.json";

  private DataUtility() {}

  public static String getTestUserPath() {
    return String.format("%s/testUser.json", RESOURCES_PATH.getString());
  }

  public static String getBasicUrl() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, String.class, "/testURL");
  }

  public static Integer getUserId() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, Integer.class, "/userId");
  }

  public static Integer getPostId() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, Integer.class, "/postId");
  }

  public static Integer getPostIdNotFound() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, Integer.class, "/postIdNotFound");
  }

  public static Integer getUserIdForModel() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, Integer.class, "/userIdForModel");
  }

  public static String getPostsEndpoint() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, String.class, "/postsEndpoint");
  }

  public static String getUsersEndpoint() {
    return JsonUtility.getValueFromJson(TEST_DATA_PATH, String.class, "/usersEndpoint");
  }

  public static PostModel getTestPost() {
    return PostModel.builder()
        .userId(DataUtility.getUserId())
        .title(RandomStringUtils.randomAlphanumeric(10))
        .body(RandomStringUtils.randomAlphanumeric(10))
        .build();
  }
}
