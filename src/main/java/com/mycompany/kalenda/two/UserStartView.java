/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalenda.two;

/**
 *
 * @author Richie Frost
 */

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;

public class UserStartView extends GridPane {
    //user creation
    private Text emailLabel;
    private Text instructionText;
    private TextField emailField;
    private User user;
    private Button userButton;
    private EventHandler<ActionEvent> userPressed;
    
    //group create or join
    private RadioButton createGroup;
    private RadioButton joinGroup;
    private int groupSize;
    private long groupID;
    private ToggleGroup tg;
    private Text groupIDText;
    private Text groupSizeText;
    private TextField groupIDField;
    private TextField groupSizeField;
    private Button groupSetButton;
    private EventHandler<ActionEvent> groupPressed;
    
    
    
    
    public UserStartView() {
        //User Creation
        emailLabel = new Text("Email Address:");
        instructionText = new Text("Please enter a vaild email address");
        userButton = new Button("Submit");
        emailField = new TextField();
        
        
        
        groupIDText = new Text("Please enter a(the) unique numeric Identifier for your group");
        groupSizeText = new Text("Please enter the number of people in your group");
        groupIDField = new TextField();
        groupSizeField = new TextField();
        groupSetButton = new Button("Submit Group Info");
        
        
        
        
        this.add(instructionText, 0,0);
        this.add(emailLabel, 0, 1);
        this.add(emailField, 1, 1);
        this.add(userButton, 0, 3);
        
        userPressed = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e) {
                    String email = emailField.getText();
                    user = new User(email);
                    changeScene();

            }
        };
        
        userButton.setOnAction(userPressed);
        
        

        
    
    
    }
    
    
    private void changeScene(){
        this.getChildren().clear();
        tg = new ToggleGroup();
        createGroup = new RadioButton("I need to Create a Group");
        joinGroup = new RadioButton("I need to join a Group");
        createGroup.setToggleGroup(tg);
        joinGroup.setToggleGroup(tg);
        
        createGroup.setOnAction(this :: radioAction);
        joinGroup.setOnAction(this :: radioAction);
        
        
        this.add(createGroup, 0, 0);
        this.add(joinGroup, 0, 1);
        
        
        
        
    }
    
    private void radioAction(ActionEvent event) {
        
        int paneSize =this.getChildren().size();
        
        if (createGroup.isSelected()) {
            
            if( paneSize == 2) {
                //only radio buttons present
                this.add(groupIDText, 0, 2);
                this.add(groupIDField, 0, 3);
                this.add(groupSizeText, 0, 4);
                this.add(groupSizeField, 0, 5);
            }
            else {
                //join fields are there
                this.getChildren().remove(groupIDText);
                this.getChildren().remove(groupIDField);
                this.add(groupIDText, 0, 2);
                this.add(groupIDField, 0, 3);
                this.add(groupSizeText, 0, 4);
                this.add(groupSizeField, 0, 5);
            }

        }
        else {
            if (paneSize == 2) {
                //only radio buttons present
                this.add(groupIDText, 0, 2);
                this.add(groupIDField, 0, 3);
            }
            else {
                this.getChildren().remove(groupIDText);
                this.getChildren().remove(groupIDField);
                this.getChildren().remove(groupSizeText);
                this.getChildren().remove(groupSizeField);
                this.add(groupIDText, 0, 2);
                this.add(groupIDField, 0, 3);
            }
        }
    }
    
    public User getUser() {
        return user;
    }
    
    
}
