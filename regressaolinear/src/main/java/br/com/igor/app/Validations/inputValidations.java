package br.com.igor.app.Validations;

public class inputValidations {

    public static boolean IsValidNumeric(String numeric) {
        try {
            Integer.parseInt(numeric);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean isValidDoubleNumeric(String numeric) {
        try {
            Double.parseDouble(numeric);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    public static boolean rangeNumeric(String numberInString) {
        if (IsValidNumeric(numberInString)) {
            int number = Integer.parseInt(numberInString);
            if (number >= 0 && number <= 9) {
                return true;
            }
        }
        return false;
    }

}