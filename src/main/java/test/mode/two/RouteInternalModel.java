package test.mode.two;

public class RouteInternalModel extends InternalModel {

  String id;
  TrackInternalModel approachTrack;

  @Override
  public String toString() {
    return "RouteInternalModel{" +
        "id='" + id + '\'' +
        ", approachTrack=" + approachTrack +
        '}';
  }

  public TrackInternalModel getApproachTrack() {
    return approachTrack;
  }

  public void setApproachTrack(TrackInternalModel approachTrack) {
    this.approachTrack = approachTrack;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
