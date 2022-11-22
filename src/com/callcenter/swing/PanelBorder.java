package com.callcenter.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author burakatlay
 */
public class PanelBorder extends javax.swing.JPanel {

    public PanelBorder() {
        initComponents();
        setOpaque(false);
        int x = 10, y = 10;
        
        for (int i=0;i < 7; i++) {
            JButton buton = new JButton("+");//enhansive button
            buton.setBounds(x, y, 40, 30);
            this.add(buton);
            
            JTextField textField = new JTextField();
            textField.setBounds(60, y, 40, 30);
            textField.setEditable(false);
            textField.setText("0");
            this.add(textField);
            
            buton.addActionListener((ActionEvent e) -> {
                    int ValueField = Integer.parseInt(textField.getText());
                    ValueField++;
                    textField.setText(String.valueOf(ValueField));
                });
            
            x = 110;
            
            buton = new JButton("-");//decreasing button
            buton.setBounds(x, y, 40, 30);
            this.add(buton);
            
            buton.addActionListener((ActionEvent e) -> {
                    int ValueField = Integer.parseInt(textField.getText());
                    ValueField--;
                    textField.setText(String.valueOf(ValueField));
                });
            
            x = 10;
            y += 30;
            
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
