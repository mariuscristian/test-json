package other;

import java.util.HashMap;
import java.util.Map;

public class Enums {

  public static void main(String[] args) {
    OperationType o = OperationType.valueOf("DELETE");
    System.out.println(OperationType.values());
    System.out.println(OperationType.get("D"));
    System.out.println(o+" | "+o.getMappedScope()+" | "+o.ordinal());
  }
}
enum OperationType {
  CREATE("C"),
  DELETE("D");
  private String mappedScope;

  OperationType(String mappedScope) {
    this.mappedScope = mappedScope;
  }

  public String getMappedScope() {
    return mappedScope;
  }
  private static final Map<String, OperationType> lookup = new HashMap<String, OperationType>();
  static {
    for (OperationType o : OperationType.values())
    {
      lookup.put(o.getMappedScope(),o);
    }
  }
  public static OperationType get(String mappedScope) {
    return lookup.get(mappedScope);
  }
}