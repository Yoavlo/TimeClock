package Swing;

import Backend.entities.Users;
import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Actions {
    private JButton exitButton;
    private JButton personalTimeHistoryButton;
    private JButton logInButton;
    private JButton logOutButton;
    private JButton createUserButton;
    private JLabel labelTime;
    private JPanel panelActions;
    private JLabel HelloUserLabel;
    private JLabel statusLabel;
    private JButton AllPeopleHistoryButton;

    public Actions() {

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getPanelActions().removeAll();
            }
        });
    }


    public JPanel getPanelActions() {
        return panelActions;
    }

    public void setPanelActions(JPanel panelActions) {
        this.panelActions = panelActions;
    }




    public Actions(JFrame frame) {
        HelloUserLabel.setText("Hello, "+UsersHandler.getCurrentUser().getUser());
        if(UsersHandler.getCurrentUser().getIsAdmin()==false)
        {
            AllPeopleHistoryButton.setVisible(false);
            createUserButton.setVisible(false);
        }

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogButton(logInButton);
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                handleLogButton(logOutButton);

            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                handleLogButton(logOutButton);

            }
        });

        AllPeopleHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(UsersHandler.getCurrentUser().getIsAdmin()) {
                 //   ArrayList<Users> historyOfAllUsers = (ArrayList) UsersHandler.getHistoryOfAllUsers(UsersHandler.getCurrentUser());
                    new PersonalTime( (ArrayList) UsersHandler.getHistoryOfAllUsers(UsersHandler.getCurrentUser()), true);
                }
                else
                {
                    statusLabel.setText("Status: You are not admin, you cant get the history of all people");

                }


            }
        });


        personalTimeHistoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    ArrayList<Users> historyUser = (ArrayList) UsersHandler.getPersonalHistroy(UsersHandler.getCurrentUser());

             //   JFrame frame = new JFrame("HomePage");
                new PersonalTime( (ArrayList) UsersHandler.getPersonalHistroy(UsersHandler.getCurrentUser()) , false);
             //   frame.setContentPane(new PersonalTime().getPersonalTimeMainPanel());
                //  frame.setContentPane(new Actions().getPanelActions());
//                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                frame.pack();
//                frame.setVisible(true);
//                frame.setContentPane(new PersonalTime().getPersonalTimeMainPanel());
//                frame.pack();
//                frame.setVisible(true);


            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setContentPane(new CreateUser().getCreateUserJPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private boolean handleLogButton(JButton button)
    {
        LocalDateTime localDateTime= LocalDateTime.now().withSecond(0).withNano(0);
        labelTime.setText(localDateTime.toLocalDate()+" "+localDateTime.toLocalTime() );

        if(logInButton==button)
        {
            logInButton.setVisible(false);
            logOutButton.setVisible(true);
            UsersHandler.saveLogIn(localDateTime.toLocalTime().toString(),localDateTime.toLocalDate().toString());
        }
        else if(logOutButton==button)
        {
            logOutButton.setVisible(false);
            logInButton.setVisible(true);
            UsersHandler.saveLogout(localDateTime.toLocalTime().toString());
        }

        return true;

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
