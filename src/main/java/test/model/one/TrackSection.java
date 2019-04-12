package test.model.one;

public class TrackSection extends ParentElement {

  String occupation;
  String marking;
  String catenary;

  public String getMarking() {
    return marking;
  }

  public void setMarking(String marking) {
    this.marking = marking;
  }

  public String getCatenary() {
    return catenary;
  }

  public void setCatenary(String catenary) {
    this.catenary = catenary;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }
}