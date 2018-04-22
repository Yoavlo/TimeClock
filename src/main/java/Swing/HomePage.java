package Swing;

import Backend.entitiesHandler.UsersHandler;
import Email.SendEmail;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.prefs.Preferences;


public class HomePage {
    private JPanel panel1;
    private JPasswordField passwordField1;
    private JTextField textFieldUser;
    private JButton logInButton;
    private JCheckBox rememberMeCheckBox;
    private JButton forgetPasswordButton;
    private JLabel labelStatus;
    Preferences prefs;
    String prefsKeyrememberMeCheckBox;
    String prefsKeyUserName;
    String prefsKeyPassword;
    SendEmail sendEmail;


    static  JFrame  globalFrame;

    public JPanel getPanel1() {
        return panel1;
    }


    // private UsersHandler usersHandler;

    public HomePage(JFrame frame) {
        globalFrame=frame;
        prefs=Preferences.userRoot().node(this.getClass().getName());
        prefsKeyrememberMeCheckBox = "rememberMeCheckBox";
        prefsKeyUserName="prefsKeyUserName";
        prefsKeyPassword="prefsKeyPassword";

        if(prefs.getBoolean(prefsKeyrememberMeCheckBox,false ))
        {
            rememberMeCheckBox.setSelected(true);
            textFieldUser.setText( prefs.get(prefsKeyUserName, "prefsKeyUserName"));
            passwordField1.setText(prefs.get(prefsKeyPassword, "prefsKeyPassword"));
        }

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordField=String.copyValueOf(passwordField1.getPassword());
                if(rememberMeCheckBox.isSelected())

                {

                    prefs.putBoolean(prefsKeyrememberMeCheckBox,true);
                    prefs.put(prefsKeyUserName,textFieldUser.getText() );
                    prefs.put(prefsKeyPassword,textFieldUser.getText() );
                }
                else
                {
                    prefs.putBoolean(prefsKeyrememberMeCheckBox,false);
                }





                UsersHandler.initialize();
                if(UsersHandler.checkPassword(textFieldUser.getText(),passwordField))
                {
                    System.out.println("go to diffrent frame");
                  //  panel1.removeAll();
                //    panel1.repaint();

                    frame.setContentPane(new Actions(frame).getPanelActions());
                    frame.setJMenuBar(Menu.getjMenuBar());
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


        forgetPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    sendEmail=new SendEmail( "emailfrom@com","password", "emailto@com", "Title", "messageBody");

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


