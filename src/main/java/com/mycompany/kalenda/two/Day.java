/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalenda.two;

/**
 *
 * @author Richie Frost
 */

import java.io.Serializable;

public class Day implements Serializable {
    
    private Boolean[] times = new Boolean[24];
    private DayNames dayname;
    
    public Day(DayNames dayname) {
        
        this.dayname = dayname;
        
        
        for(int i=0; i<24; i++) {
            times[i] = Boolean.FALSE;
        }
    }
    
    public Boolean[] getTimes() {
        return times;
    }
    
    public void setTime(int time, Boolean avail) {
        
        if (time < 0 || time > 23) {
            System.out.println("Invalid Time");
        }
        else {
            times[time] = avail;
        }
    }
    
    public DayNames getDayName () {
        return dayname;
    }
    
    public void setEntireDay(String dayString) {
        
        if (dayString.length() != 24) {
            System.out.println("Invalid Input Format!");
        }
        else {
            Boolean[] fullDay = new Boolean[24];
//            int[] integerRep = new int[48];
            char[] temp = dayString.toCharArray();
            
            for (int i = 0; i < 24; i++) {

                if (temp[i] == '1') {
                    fullDay[i] = true;
                }
                else if (temp[i] == '0') {
                    fullDay[i] = false;
                }
                else {
                    System.out.println("Invalid Format");
                    break;
                }
                
            }
            times = fullDay;
        
        }
    }
    
    
    
}
