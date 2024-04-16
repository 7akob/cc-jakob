package fi.arcada.codechallenge;

public class Statistics {

    public static double[] sma(double[] values){

        double[] sma = new double[values.length -2];

        for (int i = 0; i < sma.length; i++) {
            sma[i] = (values[i] + values[i + 1] + values[i+2]) / 3.0;
        }

        return sma;
    }
}
