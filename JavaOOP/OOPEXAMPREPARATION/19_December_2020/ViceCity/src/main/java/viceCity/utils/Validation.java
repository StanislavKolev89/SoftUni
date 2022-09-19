package viceCity.utils;

public class Validation {
    private Validation() {
    }

    public static String validateName(String name, String exceptionMessage) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
        return name;
    }
}
