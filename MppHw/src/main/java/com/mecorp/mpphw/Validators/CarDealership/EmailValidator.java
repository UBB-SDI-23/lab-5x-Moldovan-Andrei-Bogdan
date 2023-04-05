package com.mecorp.mpphw.Validators.CarDealership;

import java.util.regex.Pattern;

public class EmailValidator {
    private final static String emailRegex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

    public static boolean validateEmail(String email) {
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
}
