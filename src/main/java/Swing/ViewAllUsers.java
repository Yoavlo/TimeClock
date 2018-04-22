package Swing;

import Backend.entities.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ViewAllUsers {

    public ViewAllUsers(List<Users> allUsers)
    {
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }

        };

        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Admin");

        for(Users user: allUsers)
        {
            model.addRow(new Object[]{user.getUser(), user.getEmail(), user.getIsAdmin()});
        }
        table.setModel(model);

        JFrame f = new JFrame();
        f.setSize(300, 300);
        f.add(new JScrollPane(table));
        f.setVisible(true);
    }
}
