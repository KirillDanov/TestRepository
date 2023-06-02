package models;

import lombok.Data;

@Data
public class Company {
  private String name;
  private String catchPhrase;
  private String bs;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Company other) {
      return this.name.equals(other.name)
          && this.catchPhrase.equals(other.catchPhrase)
          && this.bs.equals(other.bs);
    }
    return false;
  }
}
