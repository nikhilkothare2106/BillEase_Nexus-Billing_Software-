package validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemValidation {
    private Pattern id;
    private Pattern name;
    private Pattern price;
    private Pattern quantity;
    private Matcher matcher;

    String id_pattern = "^\\d{1,3}$";
    String name_pattern = "^[A-Za-z\\s]{3,30}$";
    String price_pattern = "^([1-9][0-9]{0,4}|100000)$";
    String quantity_pattern = "^([1-9][0-9]?|100)$";

    public ItemValidation(){
        id = Pattern.compile(id_pattern);
        name = Pattern.compile(name_pattern);
        price = Pattern.compile(price_pattern);
        quantity = Pattern.compile(quantity_pattern);
    }

    public boolean idValidation(String id1){
        matcher = id.matcher(id1);
        return matcher.matches();
    }
    public boolean nameValidation(String name1){
        matcher = name.matcher(name1);
        return matcher.matches();
    }
    public boolean priceValidation(String price1){
        matcher = price.matcher(price1);
        return matcher.matches();
    }
    public boolean quantityValidation(String quantity1){
        matcher = quantity.matcher(quantity1);
        return matcher.matches();
    }
}
