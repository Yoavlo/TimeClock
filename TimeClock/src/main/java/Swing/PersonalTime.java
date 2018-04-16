package Swing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class PersonalTime {


    private JPanel personalTimeMainPanel;
    private JTable table1;

    public PersonalTime(JFrame frame) {

        Object [] columnsName={"Name","Log-in","Log-out", "Hours"};


        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("col1");
        model.addColumn("col2");
    //    model.setColumnIdentifiers(columnsName);

        table1.setModel(model);
        frame.add(new JScrollPane(table1));


        //model.addColumn(headerLabel.toString(), values);
       // table.moveColumn(table.getColumnCount()-1, vColIndex);

//        Object [] columnsName={"Name","Log-in","Log-out", "Hours"};
//        Object [][] rowsData={{"null"}};

       // frame.getContentPane().add()
     //   frame.pack();
      //  frame.setVisible(true);
//        table1.addColumn(new TableColumn(1));//username
//        table1.addColumn(new TableColumn(2));//login
//        table1.addColumn(new TableColumn(3));//logout
//        table1.addColumn(new TableColumn(4));//total hours in that time


    }

    public void setPersonalTimeMainPanel(JPanel personalTimeMainPanel) {
        this.personalTimeMainPanel = personalTimeMainPanel;
    }

    public JPanel getPersonalTimeMainPanel() {
        return personalTimeMainPanel;
    }
}
