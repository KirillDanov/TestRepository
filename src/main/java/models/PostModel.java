package models;

import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
public class PostModel {
  private Integer userId;
  private Integer id;
  private String title;
  private String body;
}
