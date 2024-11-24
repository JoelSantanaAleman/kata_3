package software.ulpgc.control;

import software.ulpgc.model.Rating;

public interface RatingDeserializer {
    Rating deserializer(String data);
}
