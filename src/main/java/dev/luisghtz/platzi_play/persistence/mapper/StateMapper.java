package dev.luisghtz.platzi_play.persistence.mapper;

import org.mapstruct.Named;

public class StateMapper {

    @Named("stringToBoolean")
    public static Boolean toBoolean(String state) {
        if (state == null || state.isEmpty())
            return false;
        return "D".equalsIgnoreCase(state);
    }

    @Named("booleanToString")
    public static String toString(Boolean state) {
        if (state == null)
            return "D";
        return state ? "D" : "F";
    }
}
