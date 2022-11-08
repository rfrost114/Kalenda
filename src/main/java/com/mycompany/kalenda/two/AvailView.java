/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalenda.two;

/**
 *
 * @author Richie Frost
 */

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.scene.control.CheckBox;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.Observable;
import java.util.Observer;
import javafx.scene.layout.Priority;


public class AvailView extends GridPane {
    private User target;
    private Button submit;
    private Text monday;
    private Text tuesday;
    private Text wednesday;
    private Text thursday;
    private Text friday;
    private Text saturday;
    private Text sunday;
    private ColumnConstraints cols;
    private EventHandler<ActionEvent> submitPressed;
    
   
    private String monTimes;
    private CheckBox[] monChecks;
    
    private String tuesTimes;
    private CheckBox[] tuesChecks;
    
    private String wedTimes;
    private CheckBox[]wedChecks;
    
    private String thursTimes;
    private CheckBox[] thursChecks;
    
    private String friTimes;
    private CheckBox[] friChecks;
    
    private String satTimes;
    private CheckBox[] satChecks;
    
    private String sunTimes;
    private CheckBox[] sunChecks;
    
    
    public AvailView (User target) {
        this.target = target;
        monday = new Text("Monday:");
        tuesday = new Text("Tuesday:");
        wednesday = new Text("Wednesday");
        thursday = new Text("Thursday:");
        friday = new Text("Friday");
        saturday = new Text("Saturday:");
        sunday = new Text("Sunday:");
        submit = new Button("Submit");
        
        monTimes = "";
        tuesTimes = "";
        wedTimes = "";
        thursTimes = "";
        friTimes = "";
        satTimes = "";
        sunTimes = "";

        monChecks = new CheckBox[24];
        tuesChecks = new CheckBox[24];
        wedChecks = new CheckBox[24];
        thursChecks = new CheckBox[24];
        friChecks = new CheckBox[24];
        satChecks = new CheckBox[24];
        sunChecks = new CheckBox[24];
        
        this.add(monday, 0, 0);
        this.add(tuesday, 1, 0);
        this.add(wednesday, 2, 0);
        this.add(thursday, 3, 0);
        this.add(friday, 4, 0);
        this.add(saturday, 5, 0);
        this.add(sunday, 6, 0);
        

        cols = new ColumnConstraints(100);
        cols.setHgrow(Priority.ALWAYS);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);
        this.getColumnConstraints().add(cols);

        
        
        
        for (int i = 0; i<24; i++) {
            
            int time;
            String timeString;
            
            if (i == 0) {
                time = 12;
                timeString = time + " AM";
            }
            else if (i > 0 && i < 12) {
                time = i;
                timeString = time + " AM";
            }
            else if (i == 12){
                time = 12;
                timeString = time + " PM";
            }
            else {
                time = i - 12;
                timeString = time + " PM";
            }
            
            
            
            monChecks[i] = new CheckBox(timeString);
            tuesChecks[i] = new CheckBox(timeString);
            wedChecks[i] = new CheckBox(timeString);
            thursChecks[i] = new CheckBox(timeString);
            friChecks[i] = new CheckBox(timeString);
            satChecks[i] = new CheckBox(timeString);
            sunChecks[i] = new CheckBox(timeString);
            
            this.add(monChecks[i], 0, i+1);
            this.add(tuesChecks[i], 1, i+1);
            this.add(wedChecks[i], 2, i+1);
            this.add(thursChecks[i], 3, i+1);
            this.add(friChecks[i], 4, i+1);
            this.add(satChecks[i], 5, i+1);
            this.add(sunChecks[i], 6, i+1);
        }
        this.add(submit, 7, 25);
        
        
        submitPressed = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                
                
                WeekAvail avail = target.getAvail();
                
                for (CheckBox cb : monChecks) {
                    if (cb.isSelected()) {
                        monTimes += "1";
                    }
                    else {
                        monTimes += "0";
                    }
                }
                
                avail.getDay(DayNames.MONDAY).setEntireDay(monTimes);
                
                for (CheckBox cb : tuesChecks) {
                    if (cb.isSelected()) {
                        tuesTimes += "1";
                    }
                    else {
                        tuesTimes += "0";
                    }
                }
                avail.getDay(DayNames.TUESDAY).setEntireDay(tuesTimes);
                
                for (CheckBox cb : wedChecks) {
                    if (cb.isSelected()) {
                        wedTimes += "1";
                    }
                    else {
                        wedTimes += "0";
                    }
                }
                avail.getDay(DayNames.WEDNESDAY).setEntireDay(wedTimes);
                
                for (CheckBox cb : thursChecks) {
                    if (cb.isSelected()) {
                        thursTimes += "1";
                    }
                    else {
                        thursTimes += "0";
                    }
                }
                avail.getDay(DayNames.THURSDAY).setEntireDay(thursTimes);
                
                for (CheckBox cb : friChecks) {
                    if (cb.isSelected()) {
                        friTimes += "1";
                    }
                    else {
                        friTimes += "0";
                    }
                }
                avail.getDay(DayNames.FRIDAY).setEntireDay(friTimes);
                
                for (CheckBox cb : satChecks) {
                    if (cb.isSelected()) {
                        satTimes += "1";
                    }
                    else {
                        satTimes += "0";
                    }
                }
                avail.getDay(DayNames.SATURDAY).setEntireDay(satTimes);
                
                for (CheckBox cb : sunChecks) {
                    if (cb.isSelected()) {
                        sunTimes += "1";
                    }
                    else {
                        sunTimes += "0";
                    }
                }
                avail.getDay(DayNames.SUNDAY).setEntireDay(sunTimes);
                
                target.getAvail().report();
            }
            
        
        };
        
        submit.setOnAction(submitPressed);
    }
}
