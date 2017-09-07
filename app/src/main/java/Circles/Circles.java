package Circles;

import Linear.Linear;

import static java.lang.StrictMath.abs;


public class Circles extends Linear {
    private double r1, r2;

    public Circles(double editAX, double editAY, double editBX, double editBY, double rad1, double rad2) {
        super(editAX, editAY, editBX, editBY);
        this.r1 = rad1;
        this.r2 = rad2;
    }

    public String commonPos(){
        StringBuilder mStringBuilder = new StringBuilder("");

        if (section() > r1 + r2){
            mStringBuilder.append("One circle is completely outside the other");
        }else if (section() == r1 + r2) {
            mStringBuilder.append("Circles touch externally");
        }else if(section() > abs(r1-r2) && section() < r1 + r2) {
            mStringBuilder.append("Circles intersect at two points");
        }else if(section() == abs(r1-r2)) {
            mStringBuilder.append("Circles touch internally");
        }else if (section() < abs(r1-r2)) {
            mStringBuilder.append("One circle is completely inside the other");
        }else {
            mStringBuilder.append("Circles have common center");
        }

        return mStringBuilder.toString();
    }
}
