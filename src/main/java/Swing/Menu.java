package Swing;

import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Menu {
    private static JMenuBar jMenuBar;
    private JPanel jPanelMenu;
    private  JMenu jMenuHistroy;
    private JMenu jMenuUsers;
    private JMenu jMenuSettings;


    public Menu( )
    {

        jMenuBar= new JMenuBar();
        jMenuHistroy= new JMenu("History");
        jMenuUsers= new JMenu("Users");
        jMenuSettings  = new JMenu("Settings");

        JMenuItem  jMenuItempersonalTimeHistory= new JMenuItem("Personal history");
        JMenuItem  jMenuIteEveryBodyTimeHistory= new JMenuItem("History of all users");
        jMenuHistroy.add(jMenuItempersonalTimeHistory);
        jMenuHistroy.add(jMenuIteEveryBodyTimeHistory);

        JMenuItem  jMenuItemCreateUser= new JMenuItem("Create user");
        JMenuItem  jMenuItemDeleteUser= new JMenuItem("Delete user");
        JMenuItem  jMenuItemViewAllUsers= new JMenuItem("View all users");
        jMenuUsers.add(jMenuItemCreateUser);
        jMenuUsers.add(jMenuItemDeleteUser);
        jMenuUsers.add(jMenuItemViewAllUsers);

        JMenuItem  jMenuItemExit= new JMenuItem("Exit");
        JMenuItem  jMenuItemLogOff= new JMenuItem("Log Off");
        JMenuItem  jMenuItemControls= new JMenuItem("Controls");
        JMenuItem  jMenuLogInLogOut= new JMenuItem("login & logout");
        jMenuSettings.add(jMenuLogInLogOut);
        jMenuSettings.add(jMenuItemExit);
        jMenuSettings.add(jMenuItemLogOff);
        jMenuSettings.add(jMenuItemControls);

        jMenuBar.add(jMenuHistroy);
        jMenuBar.add(jMenuUsers);
        jMenuBar.add(jMenuSettings);


        jMenuItempersonalTimeHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalTime( (ArrayList) UsersHandler.getPersonalHistroy(UsersHandler.getCurrentUser()) , false);
            }
        });
        jMenuIteEveryBodyTimeHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PersonalTime( (ArrayList) UsersHandler.getHistoryOfAllUsers(UsersHandler.getCurrentUser()), true);
            }
        });
        jMenuItemCreateUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.setContentPane(new CreateUser().getCreateUserJPanel());
                HomePage.globalFrame.pack();
                HomePage.globalFrame.setVisible(true);
            }
        });

        jMenuItemDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.setContentPane(new DeleteUser().getjPanelDeleteUser());
                HomePage.globalFrame.pack();
                HomePage.globalFrame.setVisible(true);
            }
        });

        jMenuItemExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.dispose();

            }
        });
        jMenuItemLogOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.setContentPane(new HomePage( HomePage.globalFrame).getPanel1());
                HomePage.globalFrame.setJMenuBar(null);
                HomePage.globalFrame.pack();
                HomePage.globalFrame.setVisible(true);
            }
        });

        jMenuItemViewAllUsers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                new ViewAllUsers( (ArrayList) UsersHandler.getAllUsers(UsersHandler.getCurrentUser()));
            }
        });

        jMenuItemControls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.setContentPane(new Controls().getjPanelControls());
                HomePage.globalFrame.pack();
                HomePage.globalFrame.setVisible(true);
            }
        });

        jMenuLogInLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //  new CreateUser().getCreateUserJPanel();
                HomePage.globalFrame.setContentPane(new Actions(HomePage.globalFrame).getPanelActions());
                HomePage.globalFrame.pack();
                HomePage.globalFrame.setVisible(true);
            }
        });








    }


    public static JMenuBar getjMenuBar() {
        return jMenuBar;
    }

    public static void main(String [] args)
    {


        JFrame frame = new JFrame("HomePage");
        frame.setContentPane(new Menu().jPanelMenu);
        //  frame.setContentPane(new Actions().getPanelActions());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setJMenuBar(getjMenuBar());
        frame.pack();
        frame.setVisible(true);



    }


}
