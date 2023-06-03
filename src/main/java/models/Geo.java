package models;

import java.util.Objects;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Geo {
  private Float lat;
  private Float lng;

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Geo other) {
      return this.lat.equals(other.lat) && this.lng.equals(other.lng);
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lng);
  }
}
