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

public class User implements Serializable {
    
    private long groupNumber;
    private int groupSize;
    private String name;
    private WeekAvail avail;
    
    
    public User(String name) {
    
        this.name = name;
        this.avail = new WeekAvail();
        
    }
    
    public String getName() {
        return name;
    }
    
    public WeekAvail getAvail() {
        return avail;
    }
    
    public void setGroupNumber(long id) {
        groupNumber = id;
    }
    
    public long getGroupNumber() {
        return groupNumber;
    }
    
    public void setGroupSize(int size) {
        groupSize = size;
    }
    
    public int getGroupSize() {
        return groupSize;
    }
    
    
}
