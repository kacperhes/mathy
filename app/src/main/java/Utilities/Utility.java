package Utilities;

import java.text.DecimalFormat;

/**
 * Created by kacpe on 23.07.2017.
 */

public abstract class Utility {
    protected static double limitPrecision(double numAsString) {
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        return Double.parseDouble(decimalFormat.format(numAsString));
    }
}
