/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.callcenter.helper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

/**
 *
 * @author burakatlay
 */
public class DigitalClockandDate extends javax.swing.JPanel {

    /**
     * Creates new form DigitalClockandDate
     */
    public DigitalClockandDate() {
        initComponents();
        int delay = 100;
        Timer timer = new Timer(delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.YYYY");
                String formattedTime = now.format(formatter);
                String formatedDate = now.format(formatterDate);
                timeLabel.setText(formattedTime);
                dateLabel.setText(formatedDate);
            }
        });

        timer.start();
    }
    
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        timeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(230, 239, 247));

        timeLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        timeLabel.setText("jLabel1");

        dateLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        dateLabel.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateLabel)
                .addGap(18, 18, 18)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(timeLabel))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables
}