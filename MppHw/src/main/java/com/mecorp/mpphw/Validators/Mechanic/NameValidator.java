package com.mecorp.mpphw.Validators.Mechanic;

import java.util.regex.Pattern;

public class NameValidator {
    private final static String nameRegex = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";

    public static boolean validateName(String name) {
        return Pattern.compile(NameValidator.nameRegex).matcher(name).matches();
    }
}
