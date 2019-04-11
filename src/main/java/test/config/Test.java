package test.config;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
}
