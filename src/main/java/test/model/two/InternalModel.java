package test.model.two;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = OccupationInternalModel.class, name = "TrackSection"),
    @JsonSubTypes.Type(value = OccupationInternalModel.class, name = "Point"),
    @JsonSubTypes.Type(value = RouteInternalModel.class, name = "Route")
})

public class InternalModel {
  String id;

  @Override
  public String toString() {
    return "InternalModel{" +
        "id='" + id + '\'' +
        '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}