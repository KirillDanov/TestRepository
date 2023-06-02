package models;

import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Address {
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private Geo geo;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Address other) {
      return this.street.equals(other.street)
          && this.suite.equals(other.suite)
          && this.city.equals(other.city)
          && this.zipcode.equals(other.zipcode)
          && this.geo.equals(other.geo);
    }
    return false;
  }
}
