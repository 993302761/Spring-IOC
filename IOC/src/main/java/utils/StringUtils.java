package utils;


public class StringUtils {
    private StringUtils() {
    }

    public static String getSetterMethodByFieldName(String name){
        return "set"+name.substring(0,1).toUpperCase()+name.substring(1);
    }
}
