
package oomotorcyclesalessystem;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

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
        rightPanel.setLayout(new GridBagLayout());
        
        /*
        Username
        */
        //set the label text
        JLabel usernameInputLabel = new JLabel("Username:");  
        usernameInputLabel.setFont(new Font("NewsGoth Lt BT", 1, 14));
        usernameInputLabel.setForeground(Color.white);
        usernameInputLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/profile.png")));
        GridBagConstraints usernameInputLabelConstraints = new GridBagConstraints();
        usernameInputLabelConstraints.gridx = 0;
        usernameInputLabelConstraints.gridy = 0;
        usernameInputLabelConstraints.ipadx = 2;
        usernameInputLabelConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        usernameInputLabelConstraints.insets = new java.awt.Insets(184, 24, 0, 0);
        rightPanel.add(usernameInputLabel, usernameInputLabelConstraints);
        
        //username text field
        JTextField usernameInputField = new JTextField();
        usernameInputField.setBackground(new java.awt.Color(127, 140, 141));
        usernameInputField.setFont(new java.awt.Font("Tahoma", 0, 14));
        usernameInputField.setForeground(new java.awt.Color(255, 255, 255));
        usernameInputField.setToolTipText("Enter username");
        usernameInputField.setBorder(null);
        GridBagConstraints usernameInputFieldConstraints = new GridBagConstraints();
        usernameInputFieldConstraints.gridx = 2;
        usernameInputFieldConstraints.gridy = 0;
        usernameInputFieldConstraints.gridwidth = 4;
        usernameInputFieldConstraints.gridheight = 2;
        usernameInputFieldConstraints.ipadx = 351;
        usernameInputFieldConstraints.ipady = 16;
        usernameInputFieldConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        usernameInputFieldConstraints.insets = new java.awt.Insets(176, 3, 0, 0);
        rightPanel.add(usernameInputField, usernameInputFieldConstraints);
        
        //insert a seprator line
        JSeparator usernameSeperator = new JSeparator();
        GridBagConstraints usernameSeperatorConstraints = new GridBagConstraints();
        usernameSeperatorConstraints.gridx = 0;
        usernameSeperatorConstraints.gridy = 2;
        usernameSeperatorConstraints.gridwidth = 8;
        usernameSeperatorConstraints.ipadx = 463;
        usernameSeperatorConstraints.ipady = 9;
        usernameSeperatorConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        usernameSeperatorConstraints.insets = new java.awt.Insets(6, 24, 0, 42);
        rightPanel.add(usernameSeperator, usernameSeperatorConstraints);
        
        /*
        Password
        */
        //set the password label text
        JLabel passwordInputLabel = new JLabel("Password: ");
        passwordInputLabel.setFont(new Font("NewsGoth Lt BT", 1, 14));
        passwordInputLabel.setForeground(Color.white);
        usernameInputLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/padlock.png")));
        GridBagConstraints passwordInputLabelConstraints = new GridBagConstraints();
        passwordInputLabelConstraints.gridx = 0;
        passwordInputLabelConstraints.gridy = 3;
        passwordInputLabelConstraints.gridwidth = 2;
        passwordInputLabelConstraints.ipadx = 14;
        passwordInputLabelConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        passwordInputLabelConstraints.insets = new java.awt.Insets(57, 24, 0, 0);
        rightPanel.add(passwordInputLabel, passwordInputLabelConstraints);
        
        //password field
        JPasswordField passwordInputField = new JPasswordField();
        passwordInputField.setBackground(new java.awt.Color(127, 140, 141));
        passwordInputField.setFont(new java.awt.Font("Tahoma", 0, 14));
        passwordInputField.setForeground(new java.awt.Color(255, 255, 255));
        passwordInputField.setToolTipText("Enter Password");
        passwordInputField.setBorder(null);
        GridBagConstraints passwordInputFieldConstraints = new GridBagConstraints();
        passwordInputFieldConstraints.gridx = 2;
        passwordInputFieldConstraints.gridy = 3;
        passwordInputFieldConstraints.gridwidth = 5;
        passwordInputFieldConstraints.gridheight = 2;
        passwordInputFieldConstraints.ipadx = 351;
        passwordInputFieldConstraints.ipady = 16;
        passwordInputFieldConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        passwordInputFieldConstraints.insets = new java.awt.Insets(49, 4, 0, 0);
        rightPanel.add(passwordInputField, passwordInputFieldConstraints);
        
        
        
        
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground( new Color(44, 62, 80));
        
        
        //create the input fields

        
        //add stuff
        login.getContentPane().add(leftPanel);
        login.getContentPane().add(rightPanel);
        

        //set visible
        login.setVisible(true);
    }
}
