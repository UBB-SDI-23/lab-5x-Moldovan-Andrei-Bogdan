package com.mecorp.mpphw.Validators.Car;

public class EngineTypeValidator {
    public static boolean validateEngineType(String engineType) {
        return engineType.contains("V") || engineType.contains("I") || engineType.contains("F");
    }
}
