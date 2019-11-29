package com.app;

import java.util.Comparator;

public class TripComparator1 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Trip trip1 = (Trip)o1;
        Trip trip2 = (Trip)o2;
        int differenceInTime = trip1.getTravelTime() - trip2.getTravelTime();
        if(differenceInTime == 0){
            if(trip1.getCompany().equals(trip2.getCompany())){
                return trip1.getStart().toSecondOfDay() - trip2.getStart().toSecondOfDay();
            }
            else{
                return trip2.getCompany().compareTo(trip1.getCompany());
            }
        }
        return differenceInTime;
    }
}