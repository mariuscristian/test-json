package test.model.two;

public class OccupationInternalModel extends InternalModel {
  private String occupation;

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
    return "OccupationInternalModel{" +
        "id='" + id + '\'' +
        ", occupation='" + occupation + '\'' +
        '}';
  }
}