package Swing;

import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Arrays;

public class HomePage {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textFieldUser;
    private JButton logInButton;
    private JCheckBox rememberMeCheckBox;
    private JButton forgetPasswordButton;
    private JLabel labelStatus;
   // private UsersHandler usersHandler;

    public HomePage(JFrame frame) {
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordField=String.copyValueOf(passwordField1.getPassword());
           //     if(textFieldUser.getText().equals("a") && passwordField.equals("abc"))
                UsersHandler.initialize();
                if(UsersHandler.checkPassword(textFieldUser.getText(),passwordField))
                {
                    System.out.println("go to diffrent frame");
                  //  panel1.removeAll();
                //    panel1.repaint();

                    frame.setContentPane(new Actions(frame).getPanelActions());
                    frame.pack();
                    frame.setVisible(true);



                }
                else
                {
                  //  labelStatus.setVisible(true);
                    labelStatus.setText("Wrong User name or password");
                }

            }
        });
    }

    public static void main(String [] args)
    {


        JFrame frame = new JFrame("HomePage");
       frame.setContentPane(new HomePage(frame).panel1);
      //  frame.setContentPane(new Actions().getPanelActions());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

}


