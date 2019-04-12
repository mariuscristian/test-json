package test.model.one;

public class Route extends ParentElement {

  String status;
  ParentElement approachTrack;

  public ParentElement getApproachTrack() {
    return approachTrack;
  }

  public void setApproachTrack(ParentElement approachTrack) {
    this.approachTrack = approachTrack;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}