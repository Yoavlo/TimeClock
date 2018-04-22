package Swing;

import Backend.entities.History;
import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static Backend.entitiesHandler.UsersHandler.getUserByUserID;


public class PersonalTime {


    private JPanel personalTimeMainPanel;

    public PersonalTime(List<History> histroyUser, boolean wantAllUser) {
        JTable table = new JTable();



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

            for(History history:historyUser)
            {
                model.addRow(new Object[]{getUserByUserID(history.getUserId()).getUser(), history.getLogin(), history.getLogout(),getDateBetweenDates(history.getLogin(), history.getLogout()) , history.getDate()});
            }
        }
        else
        {
            for(History history:historyUser)
            {
                model.addRow(new Object[]{history.getLogin(), history.getLogout(),getDateBetweenDates(history.getLogin(), history.getLogout()) , history.getDate()});
            }
        }






        table.setModel(model);




        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);

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
