package test.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import test.model.two.InternalModel;
import test.model.one.Point;
import test.model.one.Route;
import test.model.one.TrackSection;

import java.io.IOException;

public class Test {

  public static void main(String[] args) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    // setup
    Point p = new Point();
    p.setMarking("route");
    p.setOccupation("occupied");
    p.setPosition("left");
    p.setId("1");
    p.setType("bubu");
    TrackSection t = new TrackSection();
    t.setCatenary("off");
    t.setMarking("none");
    t.setOccupation("free");
    t.setId("2");
    t.setType("you can define the type twice no problem");
    Route r = new Route();
    r.setId("3");
    r.setType("shunting");
    r.setStatus("approached");
    r.setApproachTrack(t);

    // serialize to json
    String point = objectMapper.writeValueAsString(p);
    String track = objectMapper.writeValueAsString(t);
    String route = objectMapper.writeValueAsString(r);
    System.out.println(point);
    System.out.println(track);
    System.out.println(route);

    System.out.println("--------------------------------------");

    // deserialize to internal model
    InternalModel tim = objectMapper.readValue(track, InternalModel.class);
    InternalModel pim = objectMapper.readValue(point, InternalModel.class);
    InternalModel rim = objectMapper.readValue(route, InternalModel.class);
    System.out.println(tim);
    System.out.println(pim);
    System.out.println(rim);

    System.out.println("--------------------------------------");


    System.out.println("Correct JSON");
    long start = System.currentTimeMillis();
    long end, elapsed;
    System.out.println("START   = " + start);
    for (int i = 0; i < 100000; i++) {
      if (i == 10001) {
        start = System.currentTimeMillis();
      }
      try {
        objectMapper.readValue(generateMariusMessage(), InternalModel.class);
      } catch (IOException e) {
      }
    }
    end = System.currentTimeMillis();
    elapsed = end - start;
    System.out.println("END     = " + end + "\nELAPSED = " + elapsed);

    System.out.println("Wong JSON");
    start = System.currentTimeMillis();
    System.out.println("START   = " + start);
    for (int i = 0; i < 100000; i++) {
      if (i == 10001) {
        start = System.currentTimeMillis();
      }
      try {
        objectMapper.readValue(generateMariusMessageWrong(), InternalModel.class);
      } catch (IOException e) {
      }
    }
    end = System.currentTimeMillis();
    elapsed = end - start;
    System.out.println("END     = " + end + "\nELAPSED = " + elapsed);

  }

  static String generateAdiMessage() {
    return "{"
        + "\"type\":\"Point\","
        + "\"version\":\"1.0.0\","
        + "\"data\":\"{\","
        + "\"prop1\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop2\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop3\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop4\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop5\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop6\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop7\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop8\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop9\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop10\":\""
        + UUID.randomUUID()
        + "\""
        + "}}";
  }

  static String generateMariusMessage() {
    return "{"
        + "\"type\":\"Point\","
        + "\"version\":\"1.0.0\","
        + "\"prop1\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop2\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop3\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop4\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop5\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop6\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop7\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop8\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop9\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop10\":\""
        + UUID.randomUUID()
        + "\""
        + "}";
  }

  static String generateMariusMessageWrong() {
    return "{"
        + "\"type\":\"Bubu\","
        + "\"version\":\"1.0.0\","
        + "\"prop1\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop2\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop3\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop4\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop5\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop6\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop7\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop8\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop9\":\""
        + UUID.randomUUID()
        + "\","
        + "\"prop10\":\""
        + UUID.randomUUID()
        + "\""
        + "}";
  }
}
