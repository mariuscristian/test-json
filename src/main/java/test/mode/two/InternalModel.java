package test.mode.two;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = TrackInternalModel.class, name = "TrackSection"),
    @JsonSubTypes.Type(value = PointInternalModel.class, name = "Point"),
    @JsonSubTypes.Type(value = RouteInternalModel.class, name = "Route")
})

public class InternalModel {

}