package test.model.one_old;

public class Point extends ParentElement {

  String occupation;
  String position;
  String marking;

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getMarking() {
    return marking;
  }

  public void setMarking(String marking) {
    this.marking = marking;
  }

  @Override
  public String toString() {
    return "Point{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", occupation='" + occupation + '\'' +
        ", position='" + position + '\'' +
        ", marking='" + marking + '\'' +
        '}';
  }
}