package com.app;

import java.time.LocalTime;
import java.util.StringTokenizer;

public class Trip{
    public Trip(String s){
        StringTokenizer st = new StringTokenizer(s);
        company = st.nextToken();
        String s1 = st.nextToken();
        start = LocalTime.of(new Integer(s1.substring(0,2)), new Integer(s1.substring(3,5)));
        s1 = st.nextToken();
        end = LocalTime.of(new Integer(s1.substring(0,2)), new Integer(s1.substring(3,5)));
        travelTime = end.toSecondOfDay() - start.toSecondOfDay();
        if(travelTime < 0){
            travelTime += 24 * 60 * 60;
        }
    }
    private final LocalTime start;
    private final LocalTime end;
    private final String company;
    private int travelTime;
    public LocalTime getStart(){
        return start;
    }
    public String getCompany(){
        return company;
    }
    public int getTravelTime(){
        return travelTime;
    }
    public boolean isCorrect(){
        return travelTime <= 60 * 60;
    }
    @Override
    public String toString(){
        return company + " " + start + " " + end;
    }
    public boolean isBetter(Trip trip){
        if(travelTime == trip.travelTime && start.equals(trip.start)){
            return trip.company.equals("Grotty");
        }
        if(travelTime < trip.travelTime){
            boolean daily1 = end.isAfter(start);
            boolean daily2 = trip.end.isAfter(trip.start);
            if((daily1 && daily2) || (!daily1 && !daily2)){
                if(start.isAfter(trip.start) && end.isBefore(trip.end)){
                    return true;
                }
            }
            else if(daily1 && !daily2){
                if(start.isAfter(trip.start) || end.isBefore(trip.end)){
                    return true;
                }
            }
        }
        return false;
    }
}