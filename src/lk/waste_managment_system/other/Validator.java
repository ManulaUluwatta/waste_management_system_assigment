package lk.waste_managment_system.other;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Boolean isNotEmpty(String[] values) {

        if (values == null || values.length == 0) {
            return Boolean.TRUE;
        }

        for (String value : values) {
            if (!isNotEmpty(value)) {
                return Boolean.FALSE;
            }
        }

        return Boolean.TRUE;
    }

    public static Boolean isNotEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public static boolean isAlpha(String value) {
        String ePattern = "[a-zA-Z_]+";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    public static boolean isNumber(String number) {
        String ePattern = "[0-9]+";
        Pattern p = Pattern.compile(ePattern);
        Matcher m = p.matcher(number);
        return m.matches();
    }

}
