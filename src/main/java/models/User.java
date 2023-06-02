package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {
  private Integer id;
  private String name;
  private String userName;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof User other) {
      return this.name.equals(other.name)
          && this.userName.equals(other.userName)
          && this.email.equals(other.email)
          && this.phone.equals(other.phone)
          && this.address.equals(other.address)
          && this.company.equals(other.company);
    }
    return false;
  }

  @JsonProperty("username")
  public void setUserName(String userName) {
    this.userName = userName;
  }
}
