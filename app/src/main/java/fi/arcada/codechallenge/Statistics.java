package fi.arcada.codechallenge;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Statistics {

    public static double calcMode(ArrayList<Double> values) {
        ArrayList<Double> sorted = new ArrayList<>(values);

        Collections.sort(sorted);

        double currNum = sorted.get(0);
        int currFreq = 1;
        double maxNum = currNum;
        int maxFreq = 1;

        for (int i = 1; i < sorted.size() ; i++) {
            if (sorted.get(i) == currNum){
                currFreq++;
            } else {
                currNum = sorted.get(i);
            }

            if (currFreq > maxFreq){
                maxNum = currNum;
            }
        }
        return maxNum;
    }

    public static double calcStdev(ArrayList<Double> values){
        double mean = calcMean(values);

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

    public static double calcLQ(ArrayList<Double> values){
        Collections.sort(values);

        int index = (int) Math.ceil(0.25*(values.size()+1))-1;

        if(values.size() % 2 !=0){
            return values.get(index);
        }
        else {
            double lower = values.get(index);
            double upper = values.get(index +1);
            return (lower + upper) / 2;
        }
    }

    public static double calcUQ(ArrayList<Double> values){
        Collections.sort(values);

        int index = (int) Math.ceil(0.75*(values.size() +1 )) -1;

        if(values.size() % 2 !=0){
            return values.get(index);
        }
        else {
            double lower = values.get(index);
            double upper = values.get(index +1);
            return (lower + upper) /2;
        }
    }

    public static double calcLQR(ArrayList<Double> values){
        double lq = calcLQ(values);
        double uq = calcUQ(values);
        return uq-lq;
    }

}
