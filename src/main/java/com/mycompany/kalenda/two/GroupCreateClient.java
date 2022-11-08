/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kalenda.two;

/**
 *
 * @author Richie Frost
 */

import java.net.*;
import java.io.*;

public class GroupCreateClient {
    private Socket socket = null;
    private DataOutputStream out = null;
    
    public GroupCreateClient(String address, int port){
        
        try {
        
            socket = new Socket(address, port);
            System.out.println("Connection created");
            
            out = new DataOutputStream(socket.getOutputStream());
            
        
        }
        catch (UnknownHostException e) {
            System.out.println(e);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    
    }
}
