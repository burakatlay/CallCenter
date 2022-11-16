package com.callcenter.frame;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author burakatlay
 */
public class messageBox extends JOptionPane{
    
    public void UserNotFound(){
        
        JOptionPane.showMessageDialog(null,"User Not Found","Warning",JOptionPane.ERROR_MESSAGE);

    }
}
