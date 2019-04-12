package test.mode.two;

public class TrackInternalModel extends InternalModel {

  String id;
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

  @Override
  public String toString() {
    return "TrackInternalModel{" +
        "id='" + id + '\'' +
        ", occupation='" + occupation + '\'' +
        '}';
  }
}