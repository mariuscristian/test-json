package test.model.two;

import java.util.List;

public class RouteInternalModel extends InternalModel {

  private List<InternalModel> approachTrack;

  @Override
  public String toString() {
    return "RouteInternalModel{" +
        "id='" + id + '\'' +
        ", approachTrack=" + approachTrack +
        '}';
  }

  public List<InternalModel> getApproachTrack() {
    return approachTrack;
  }

  public void setApproachTrack(List<InternalModel> approachTrack) {
    this.approachTrack = approachTrack;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
