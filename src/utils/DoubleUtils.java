package utils;

import java.text.DecimalFormat;

public class DoubleUtils {
    public static String format(Double value){
        return new DecimalFormat("#.##").format(value);
    }
}
