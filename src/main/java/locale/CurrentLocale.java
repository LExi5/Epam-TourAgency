package locale;

public class CurrentLocale {

    private static String locale = "en";

    public static void setLocale(String locale) {
        CurrentLocale.locale = locale;
    }

    public static String getLocale() {
        return locale;
    }
}
