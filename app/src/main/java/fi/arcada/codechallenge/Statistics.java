package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Statistics {

    public static double calcStdev(ArrayList<Double> values){
    double sum = 0.0;
        for (double num : values) {
            sum += num;
        }
        double mean = sum / values.size();

        double sumSquaredDiff = 0.0;
        for (double num : values) {
            sumSquaredDiff += Math.pow(num - mean, 2);
        }

        double variance = sumSquaredDiff / values.size();

        double standardDeviation = Math.sqrt(variance);

        return standardDeviation;
    }

    public static double calcMedian(ArrayList<Double> values){
        //skapar en kopia av values
        ArrayList<Double> sorted = new ArrayList<>(values);
        //sedan sorterar vi kopian annars sorteras ursprungliga datamängden
        Collections.sort(sorted);

        //Detta funkar, ännu bättre skulle vara att kolla skilt för jämna datamänder
        //Medelvärde av de två mittersta
        int midIndex = sorted.size()/2;

        //medianen är det mittersta värdet i vår sorterade datamängd
        return sorted.get(midIndex);

    }

    public static double calcMean(ArrayList<Double> values){
        double medeltal = 0.0;
        for(int i = 0; i < values.size(); i++){
            medeltal += values.get(i);
        }
        return medeltal / values.size();
    }
}
