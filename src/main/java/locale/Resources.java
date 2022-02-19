package locale;

import locale.CurrentLocale;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resources {
    public static String getValue(String key) {
        Locale locale = new Locale(CurrentLocale.getLocale());
        ResourceBundle resourceBundle = ResourceBundle.getBundle("resources", locale);
        return resourceBundle.getString(key);
    }
}
