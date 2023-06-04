/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.callcenter.helper;

import javax.swing.JOptionPane;

/**
 *
 * @author burakatlay
 */
public class Helper {

    public static void showMsg(String str) {
        String msg;

        msg = switch (str) {
            case "fill" -> "Please fill in all fields!";
            case "update" -> "The record update.";
            case "add" -> "New record added.";
            case "delete"->"Record delete";
            case "unselect"->"Are you sure you select subproject?";   
            case "questionDelete"->"Are you sure you want to delete the record?";   
            default -> str;
        };
        
        JOptionPane.showMessageDialog(null, msg,"Message",JOptionPane.INFORMATION_MESSAGE);
    }

}
