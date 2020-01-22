package test.model.two;

import java.util.List;

public class RouteInternalModel extends InternalModel {

  String id;
  List<TrackInternalModel> approachTrack;

  @Override
  public String toString() {
    return "RouteInternalModel{" +
        "id='" + id + '\'' +
        ", approachTrack=" + approachTrack +
        '}';
  }

  public List<TrackInternalModel> getApproachTrack() {
    return approachTrack;
  }

  public void setApproachTrack(List<TrackInternalModel> approachTrack) {
    this.approachTrack = approachTrack;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
