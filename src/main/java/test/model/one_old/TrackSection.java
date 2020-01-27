package test.model.one_old;

public class TrackSection extends ParentElement {

  String occupation;
  String marking;

  public String getMarking() {
    return marking;
  }

  public void setMarking(String marking) {
    this.marking = marking;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  @Override
  public String toString() {
    return "TrackSection{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", occupation='" + occupation + '\'' +
        ", marking='" + marking + '\'' +
        '}';
  }
}