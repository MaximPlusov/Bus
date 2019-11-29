package com.app;

import java.util.Comparator;

public class TripComparator2 implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Trip trip1 = (Trip)o1;
        Trip trip2 = (Trip)o2;
        return trip1.getStart().toSecondOfDay() - trip2.getStart().toSecondOfDay();
    }
}