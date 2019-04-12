package test.model.two;

public class PointInternalModel extends InternalModel {

  String id;

  @Override
  public String toString() {
    return "PointInternalModel{" +
        "id='" + id + '\'' +
        '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
