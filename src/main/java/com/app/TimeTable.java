package com.app;

import java.util.ArrayList;
import java.util.TreeSet;

class TimeTable{
    public TimeTable(TreeSet<Trip> tripSet){
        tripList = new ArrayList(tripSet.size());
        while(!tripSet.isEmpty()){
            Trip trip = tripSet.pollFirst();
            boolean flag = false;
            for(int j = 0; j < tripList.size(); j++){
                if(tripList.get(j).isBetter(trip)){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                tripList.add(trip);
            }
        }
        tripList.sort(new TripComparator2());
    }
    private ArrayList<Trip> tripList;
    @Override
    public String toString(){
        String s = "";
        for(Trip trip : tripList){
            if(trip.getCompany().equals("Posh")){
                s += trip + "\n";
            }
        }
        s += "\n";
        for(Trip trip : tripList){
            if(trip.getCompany().equals("Grotty")){
                s += trip + "\n";
            }
        }
        return s;
    }
}