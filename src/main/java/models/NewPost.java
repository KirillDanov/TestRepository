package models;

import lombok.Data;

@Data
public class NewPost {
  private final Integer userId;
  private final String title;
  private final String body;

  public NewPost(Integer userId, String title, String body) {
    this.userId = userId;
    this.title = title;
    this.body = body;
  }
}
