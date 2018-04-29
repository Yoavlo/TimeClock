package Excel;


import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileWriter;
import java.io.IOException;

public class ExcelWriter {
    //http://poi.apache.org/
    JFileChooser chooser;
    String locationExcel;
    JTable jTable;
    FileWriter excel;
    


    public ExcelWriter(JTable jTable) {
        this.jTable=jTable;
        openWindow();
        writeExcel();
        
    }



    private void openWindow() {
        JFileChooser chooser = new JFileChooser();
       // int returnVal = chooser.showOpenDialog(new JFrame());
    //    int returnVal = chooser.showOpenDialog(null);
        int returnVal = chooser.showSaveDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            setLocationExcel(chooser.getSelectedFile().toString());
        }
    }

    private void writeExcel() {
        TableModel  tableMode= this.jTable.getModel();
        try {
             excel = new FileWriter(getLocationExcel());
            for (int i=0; i<tableMode.getColumnCount();i++) {
                excel.write(tableMode.getColumnName(i) + "\t");
                excel.write("\n");
            }


            for(int i=0; i< tableMode.getRowCount(); i++) {
                for (int j = 0; j < tableMode.getColumnCount(); j++) {
                    excel.write(tableMode.getValueAt(i, j).toString() + "\t");
                    excel.write("\n");
                }
            }

            excel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    public FileWriter getExcel() {
        return excel;
    }

    public void setExcel(FileWriter excel) {
        this.excel = excel;
    }

    private void setLocationExcel(String location) {
        locationExcel=location;
    }



    private String getLocationExcel()
    {
      return  this.locationExcel;
    }


}
