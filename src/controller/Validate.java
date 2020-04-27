package controller;

import javafx.css.Match;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    public final String PHONE_NUMBER_REGEX = "^0[0-9]{9}$";
    public final String GROUP_REGEX = "^[A-Za-z0-9_]+$";
    public final String FULL_NAME_REGEX = "^[A-Za-z\\s]+$";
    public final String GENDER_REGEX = "^[A-Za-z]+$";
    public final String ADDRESS_REGEX = "^[A-Za-z0-9\\s]+$";
    public final String BIRTH_DAY_REGEX = "^[0-9\\s\\-]+$";
    public final String EMAIL_REGEX = "^[A-Za-z0-9_]+@[A-Za-z0-9]+(.[A-Za-z0-9]+)$";

    public boolean isValidate(String regex, String string){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }


}
