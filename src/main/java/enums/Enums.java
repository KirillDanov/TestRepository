package enums;

import lombok.Getter;

@Getter
public enum Enums {
  ROOT_NODE(""),
  RESOURCES_PATH("src/main/resources");
  private final String string;

  Enums(String string) {
    this.string = string;
  }
}
