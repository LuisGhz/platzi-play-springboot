package dev.luisghtz.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean toBoolean(String state) {
        return "D".equalsIgnoreCase(state);
    }

    @Named("booleanToString")
    public static String toString(Boolean state) {
        return state ? "D" : "F";
    }
}
