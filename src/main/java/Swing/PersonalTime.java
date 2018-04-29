package Swing;

import Backend.entities.History;
import Backend.entitiesHandler.UsersHandler;
import Excel.ExcelWriter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static Backend.entitiesHandler.UsersHandler.getUserByUserID;


public class PersonalTime {


    private JPanel personalTimeMainPanel;
    private JPanel panelButton;

    public PersonalTime(List<History> histroyUser, boolean wantAllUser) {
        JTable table = new JTable();
        Panel titlePanel=new Panel();





        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }

        };
        if(wantAllUser==true) {
            model.addColumn("UserName");
        }


        model.addColumn("login");
        model.addColumn("logout");
        model.addColumn("Time");
        model.addColumn("Date");


        ArrayList<History> historyUser= (ArrayList) histroyUser;
        if(wantAllUser==true)
        {
            titlePanel.add(new JLabel("Time of all users"));
            for(History history:historyUser)
            {
                model.addRow(new Object[]{getUserByUserID(history.getUserId()).getUser(), history.getLogin(), history.getLogout(),getDateBetweenDates(history.getLogin(), history.getLogout()) , history.getDate()});
            }
        }
        else
        {
            titlePanel.add(new JLabel("Personal time"));
            for(History history:historyUser)
            {
                model.addRow(new Object[]{history.getLogin(), history.getLogout(),getDateBetweenDates(history.getLogin(), history.getLogout()) , history.getDate()});
            }
        }


        table.setModel(model);


        setupButtonExtractExcel(table);


        JFrame f = new JFrame();
        f.setSize(300, 300);

        f.getContentPane().add(titlePanel, BorderLayout.NORTH);
        f.getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
        f.getContentPane().add(this.panelButton, BorderLayout.SOUTH);

        f.setVisible(true);

    }

    private void setupButtonExtractExcel(JTable jTable) {
        JButton buttonExtractExcel= new JButton("extract to Excel ");
        this.panelButton = new JPanel();
        this.panelButton.add(buttonExtractExcel);
        buttonExtractExcel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ExcelWriter(jTable);
            }
        });

    }


    public String getDateBetweenDates(String login, String logout)
    {
         login= "2018-01-04 "+login;
         logout= "2018-01-04 "+logout;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTimeLogin = LocalDateTime.parse(login, formatter);
        LocalDateTime dateTimelogout = LocalDateTime.parse(logout, formatter);

        String hours=String.valueOf(ChronoUnit.MINUTES.between(dateTimeLogin, dateTimelogout) / 60 );
        String minutes=  String.valueOf(ChronoUnit.MINUTES.between(dateTimeLogin, dateTimelogout) % 60);

        hours= ( (hours.length()==1) ? "0"+hours: hours );
        minutes= ( (minutes.length()==1) ? "0"+minutes: minutes );

        return hours+":"+minutes;

    }


}
