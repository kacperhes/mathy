package Linear;

import Utilities.Utility;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.atan;
import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;
import static java.lang.StrictMath.toDegrees;

/**
 * Created by kacpe on 22.07.2017.
 */

public class Linear extends Utility {
    private double ax, ay, bx, by;

    public Linear(double editAX, double editAY, double editBX, double editBY) {
        this.ax = editAX;
        this.ay = editAY;
        this.bx = editBX;
        this.by = editBY;
    }

    public double section() {
        return limitPrecision(abs(sqrt(pow(bx-ax, 2.0) + pow(by-ay, 2.0))));
    }

    public double getFactor() {
        return limitPrecision((by-ay)/(bx-ax));
    }

    public double getB() {
        return limitPrecision(-getFactor()*ax +ay);
    }

    public String getForm() {
        StringBuilder mStringBUilder = new StringBuilder();
        mStringBUilder.append("f(x) = ");
        mStringBUilder.append((getFactor() == 0) ?
                "" : (getFactor() == 1) ?
                "x" : (getFactor() == -1) ?
                "-x" : getFactor() + "x");
        mStringBUilder.append((getB() == 0) ? "" : (getB() > 0) ? " + " + getB() : " - " + -1*getB());

        return mStringBUilder.toString();
    }

    public String getAngle() {
        StringBuilder mStringBuilder = new StringBuilder("");
        double angle = abs(limitPrecision(toDegrees(atan(getFactor()))));
        mStringBuilder.append(angle)
                .append("°");
        return mStringBuilder.toString();
    }

}
