package fi.arcada.codechallenge;

public class Statistics {

    public static double calcMean(double[] values){
        double medeltal = 0.0;
        for(int i = 0; i < values.length; i++){
            medeltal += values[i];
        }
        return medeltal / values.length;
    }
}
