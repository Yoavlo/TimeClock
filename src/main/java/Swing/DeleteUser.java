package Swing;

import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser {
    private JButton deleteUserButton;
    private JTextField textField1;
    private JPanel jPanelDeleteUser;
    private JLabel jLabelStatus;

    public JPanel getjPanelDeleteUser() {
        return jPanelDeleteUser;
    }

    public DeleteUser() {
        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsersHandler.deleteUser(textField1.getText());
                jLabelStatus.setText(textField1.getText() +"was deleted successfully" );
            }
        });
    }
}
