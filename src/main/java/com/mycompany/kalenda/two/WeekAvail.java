/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalenda.two;

import java.util.Arrays;

/**
 *
 * @author Richie Frost
 */

import java.io.Serializable;

public class WeekAvail implements Serializable{
    
//    private Day sunday;
//    private Day monday;
//    private Day tuesday;
//    private Day wednesday;
//    private Day thursday;
//    private Day friday;
//    private Day saturday;
    private Day[] week;
    
    public WeekAvail() {
        
//        this.sunday = new Day(DayNames.SUNDAY);
//        this.monday = new Day(DayNames.MONDAY);
//        this.tuesday = new Day(DayNames.TUESDAY);
//        this.wednesday = new Day(DayNames.WEDNESDAY);
//        this.thursday = new Day(DayNames.THURSDAY);
//        this.friday = new Day(DayNames.FRIDAY);
//        this.saturday = new Day(DayNames.SUNDAY);
        week = new Day[7];
        int i = 0;
        for (DayNames dayName : DayNames.values()) {
            week[i] = new Day(dayName);
            i++;
        }
        
    }
    
    public Day[] getWeek() {
        return week;
    }
    
    public Day getDay(DayNames dayName) {
        for (Day day : week) {
            if (day.getDayName() == dayName) {
                return day;
            }
        }
        return null;
    }
    
    public void report() {
        for (Day day : week) {
            System.out.println(Arrays.toString(day.getTimes()));
        
        }
    
    }
    
    
    
    
    
}
