package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegValidation {
    private Pattern name;
    private Pattern email;
    private Pattern password;
    private Pattern phone;
    private Matcher matcher;

    String name_pattern = "^[A-Za-z\\s]{3,30}$";
    String password_pattern = "^.{4,}$";
    String phone_pattern = "^[0-9]{10}$";
    String email_pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";

    public RegValidation(){
        name = Pattern.compile(name_pattern);
        email = Pattern.compile(email_pattern);
        password = Pattern.compile(password_pattern);
        phone = Pattern.compile(phone_pattern);
    }

    public boolean nameValidation(String name1){
        matcher = name.matcher(name1);
        return matcher.matches();
    }
    public boolean emailValidation(String email1){
        matcher = email.matcher(email1);
        return matcher.matches();
    }
    public boolean passwordValidation(String password1){
        matcher = password.matcher(password1);
        return matcher.matches();
    }
    public boolean phonenoValidation(String phone1){
        matcher = phone.matcher(phone1);
        return matcher.matches();
    }
}
