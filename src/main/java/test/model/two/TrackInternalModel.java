package test.model.two;

public class TrackInternalModel extends InternalModel {
  String id;
  String type;
  String occupation;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public String toString() {
    return "TrackInternalModel{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", occupation='" + occupation + '\'' +
        '}';
  }
}