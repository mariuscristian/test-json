package test.cost.model.scicc;

public class PoweredMovableElement implements Element{
  public enum ActiveControl {IN_ACTIVE_CONTROL, NOT_IN_ACTIVE_CONTROL}
  public enum Occupation {OCCUPIED, NOT_OCCUPIED ,DISTURBED}
  //...
  ActiveControl activeControl;
  Occupation occupation;
}
