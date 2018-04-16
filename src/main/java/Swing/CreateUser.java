package Swing;

import Backend.Validation.CreateUserValidation;
import Backend.entities.Users;
import Backend.entitiesHandler.UsersHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUser    {
    private JButton creatUserButton;
    private JCheckBox isadminCheckBox;
    private JTextField userNameTestField;
    private JPasswordField passwordTestField;
    private JTextField emailTextField;
    private JLabel statusJLabel;
    private  JPanel CreateUserJPanel;

    private
    Users user;
    private CreateUserValidation createUserValidation;


    public CreateUser() {
        super();
        user=new Users();
        createUserValidation =new CreateUserValidation();

        creatUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setIsAdmin(isadminCheckBox.isSelected());

                user.setEmail(emailTextField.getText());
                user.setUser(userNameTestField.getText());

                String passwordField=String.copyValueOf(passwordTestField.getPassword());
                user.setPassword(passwordField);

                if(createUserValidation.isUserNameExistInDB(user.getUser())==false) {
                    UsersHandler.createNewUser(user);
                    statusJLabel.setText("User created successfully");
                }
                else
                {
                    statusJLabel.setText("User name exist already");
                }
              //  }
             //   {

               // }



            }
        });
    }

    public JPanel getCreateUserJPanel() {
        return CreateUserJPanel;
    }

    public void setCreateUserJPanel(JPanel createUserJPanel) {
        CreateUserJPanel = createUserJPanel;
    }
}
