/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcash;

import java.awt.Color;
import javax.swing.JTextField;

/**
 *
 * @author Azmol-IT
 */
public class CustomizeWork {
    
    public boolean numberCheck(String str, JTextField txt){
        boolean result = false;
        String pattern = "^[0]+[1]+[5679]+[0-9]{8}$";
        
        if (str.matches(pattern)) {
            result = true;
            txt.setBackground(Color.WHITE);
        }else{
            txt.setBackground(Color.red);
        }
        return result;
    }
    
}
