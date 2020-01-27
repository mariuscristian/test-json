package test.model.one_old;

import java.util.List;

public class Route extends ParentElement {

  String status;
  List<ParentElement> approachTrack;

  public List<ParentElement> getApproachTrack() {
    return approachTrack;
  }

  public void setApproachTrack(List<ParentElement> approachTrack) {
    this.approachTrack = approachTrack;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Route{" +
        "id='" + id + '\'' +
        ", type='" + type + '\'' +
        ", status='" + status + '\'' +
        ", approachTrack=" + approachTrack +
        '}';
  }
}