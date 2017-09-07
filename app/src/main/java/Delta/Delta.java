package Delta;

import Utilities.Utility;

import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;


public class Delta extends Utility {
    private double a, b, c;

    public Delta(double delta_a, double delta_b, double delta_c){
        this.a = delta_a;
        this.b = delta_b;
        this.c = delta_c;
    }

    public double deltaValue(){
        double delta = pow(b, 2.0) - 4*a*c;
        return Double.parseDouble(String.valueOf(limitPrecision(delta)));
    }

    public String rootedDelta() {
        try{
            double rootOfDelta = sqrt(deltaValue());
            return "√" + limitPrecision(rootOfDelta);
        }catch (NumberFormatException e){
            return "No rooted delta";
        }
    }

    public double[] deltaRoots(){
        if (deltaValue() < 0) {
            return new double[0];
        }else if(deltaValue() == 0) {
            return new double[]{(limitPrecision(-b/(2*a)))};
        }else{
            return new double[]{
                    limitPrecision(-b-sqrt(deltaValue())/(2*a)),
                    limitPrecision(-b+sqrt(deltaValue())/(2*a))
            };
        }
    }

    public String getPicks() {
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append("W = (")
                .append(limitPrecision(getP()))
                .append(" ; ")
                .append(limitPrecision(getQ()))
                .append(")");
        return stringBuilder.toString();
    }

    public String getCanonicalForm() {
        StringBuilder mStringBuilder = new StringBuilder("");
        mStringBuilder.append("f(x) = ");
        if (a != 0){
            mStringBuilder.append((a == 1) ? "" : (a ==-1) ? "-" : a)
                        .append("(x ")
                        .append((limitPrecision(getP()) == 0) ? "" : (limitPrecision(getP()) < 0) ?
                                "+ " + limitPrecision(getP()*-1) : "- " + limitPrecision(getP()))
                        .append(")² ")
                    .append((limitPrecision(getQ()) == 0) ? "" : (limitPrecision(getQ()) < 0) ? "- "
                            + limitPrecision(getQ()*-1) : "+ " + limitPrecision(getQ()));
        }
        return mStringBuilder.toString();
    }

    public String getProductForm(){
        StringBuilder mStringBuilder = new StringBuilder("");
        if (deltaRoots().length == 0) {
            mStringBuilder.append("This form does not exist!");
        }else if (deltaRoots().length == 1) {
            mStringBuilder.append("f(x) = ")
                    .append((a == 1) ? "" : (a ==-1) ? "-" : a)
                    .append("(x ")
                    .append((deltaRoots()[0] < 0) ? "+ " + deltaRoots()[0]*-1 : "- " + deltaRoots()[0])
                    .append(")²");
        }else{
            mStringBuilder.append("f(x) = ")
                    .append((a == 1) ? "" : (a ==-1) ? "-" : a)
                    .append("(x ")
                    .append((deltaRoots()[0] < 0) ? "+ " + deltaRoots()[0]*-1 : "- " + deltaRoots()[0])
                    .append(")(x")
                    .append((deltaRoots()[1] < 0) ? "+ " + deltaRoots()[1]*-1 : "- " + deltaRoots()[1])
                    .append(")");
        }
        return mStringBuilder.toString();
    }

    public double getP() {
        return -b/(2*a);
    }
    public double getQ(){
        return deltaValue()/(4*a);
    }
}
