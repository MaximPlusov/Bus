package com.app;

import java.io.*;
import java.util.*;

public class BusStop {
    public static void main(String[] args) throws Exception{
        TreeSet<Trip> tripSet = new TreeSet(new TripComparator1());
        try (BufferedReader in = new BufferedReader(new FileReader(args[0]))){
            String str;
            while ((str = in.readLine()) != null) {
                Trip trip = new Trip(str);
                if (trip.isCorrect()) {
                    tripSet.add(trip);
                }
            }
        }
        TimeTable timeTable = new TimeTable(tripSet);
        try (PrintWriter out = new PrintWriter(new FileWriter("output.txt"))){
            out.print(timeTable);
        }
    }
}