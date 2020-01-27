import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestOldModel {

  public static void main(String[] args) throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    // setup
    test.model.one.Point p = new test.model.one.Point();
    p.setMarking("route");
    p.setOccupation("occupied");
    p.setPosition("left");
    p.setId("1");
    p.setType("bubu");
    test.model.one.TrackSection t = new test.model.one.TrackSection();
    t.setCatenary("off");
    t.setMarking("none");
    t.setOccupation("free");
    t.setId("2");
    t.setType("you can define the type twice no problem");
    List<test.model.one.ParentElement> tl = new ArrayList<test.model.one.ParentElement>();
    tl.add(t);
    t.setId("3");
    tl.add(t);
    test.model.one.Route r = new test.model.one.Route();
    r.setId("3");
    r.setType("shunting");
    r.setStatus("approached");
    r.setApproachTrack(tl);

    // serialize to json
    String point = objectMapper.writeValueAsString(p);
    String track = objectMapper.writeValueAsString(t);
    String route = objectMapper.writeValueAsString(r);
    System.out.println(point);
    System.out.println(track);
    System.out.println(route);

    System.out.println("--------------------------------------");

    // deserialize to internal model
    test.model.one_old.ParentElement tim = null;
    try {
      tim = objectMapper.readValue(track, test.model.one_old.ParentElement.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    test.model.one_old.ParentElement pim = null;
    try {
      pim = objectMapper.readValue(point, test.model.one_old.ParentElement.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    test.model.one_old.ParentElement rim = null;
    try {
      rim = objectMapper.readValue(route, test.model.one_old.ParentElement.class);
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(tim);
    System.out.println(pim);
    System.out.println(rim);
  }
}
