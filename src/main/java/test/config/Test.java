package test.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import test.model.Point;
import test.model.TrackSection;

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
        TrackSection t = new TrackSection();
        t.setCatenary("off");
        t.setMarking("none");
        t.setOccupation("free");
        t.setId("2");

        // serialize to json
        String point = objectMapper.writeValueAsString(p);
        String track = objectMapper.writeValueAsString(t);
        System.out.println(point);
        System.out.println(track);

        // deserialize to internal model
        InternalModel tim = objectMapper.readValue(track, InternalModel.class);
        InternalModel pim = objectMapper.readValue(point, InternalModel.class);
        System.out.println(tim);
        System.out.println(pim);

        /* -------------------------------------- */

        System.out.println("Correct JSON");
        long start = System.nanoTime();
        long end, elapsed;
        System.out.println("START   = "+start);
        for (int i=0; i<100000; i++) {
            if (i==10001) start = System.nanoTime();
            try {
                objectMapper.readValue(generateMariusMessage(), InternalModel.class);
            } catch (IOException e) {
            }
        }
        end = System.nanoTime();
        elapsed = end - start;
        System.out.println("END     = " + end + "\nELAPSED = " + elapsed);

        System.out.println("Wong JSON");
        start = System.nanoTime();
        System.out.println("START   = "+start);
        for (int i=0; i<100000; i++) {
            if (i==10001) start = System.nanoTime();
            try {
                objectMapper.readValue(generateMariusMessageWrong(), InternalModel.class);
            } catch (IOException e) {
            }
        }
        end = System.nanoTime();
        elapsed = end - start;
        System.out.println("END     = " + end + "\nELAPSED = " + elapsed);

    }

    @JsonTypeInfo(
            use = JsonTypeInfo.Id.NAME,
            include = JsonTypeInfo.As.PROPERTY,
            property = "type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = TrackInternalModel.class, name = "TrackSection"),
            @JsonSubTypes.Type(value = PointInternalModel.class, name = "Point")
    })
    static class InternalModel {
    }

    static class TrackInternalModel extends InternalModel {
        String id;
        String occupation;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOccupation() {
            return occupation;
        }

        public void setOccupation(String occupation) {
            this.occupation = occupation;
        }

        @Override
        public String toString() {
            return "TrackInternalModel{" +
                    "id='" + id + '\'' +
                    ", occupation='" + occupation + '\'' +
                    '}';
        }
    }

    static class PointInternalModel extends InternalModel {
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
