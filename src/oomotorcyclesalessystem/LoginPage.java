
package oomotorcyclesalessystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginPage {
    
    public LoginPage(){
        
        //create a new Jframe
        JFrame login = new JFrame("Login Page");
        
        //set the frame
        login.setSize(1000, 700);
        login.setResizable(false);
        login.setLayout(new GridLayout (1,2)); //set the layout to have 1 row and 2 columns
        login.setLocationRelativeTo(null); //centers the component
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //create the jpanels and content to the panels
        //right Jpanel
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground( new Color(52, 73, 94));
        rightPanel.setLayout(new GridLayout(10,10));
        //set the jlabel
        JLabel usernameInputText = new JLabel("Username:");  
        usernameInputText.setFont(new Font("NewsGoth Lt BT", 1, 14));
        usernameInputText.setForeground(Color.white);
        usernameInputText.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")));
        rightPanel.add(usernameInputText);
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground( new Color(44, 62, 80));
        
        //create the input fields
        //rightPanel.setLayout(new GridLayout (8,4)); //create the layout
        
        
        //add stuff
        login.getContentPane().add(leftPanel);
        login.getContentPane().add(rightPanel);
        

        //set visible
        login.setVisible(true);
    }
}
