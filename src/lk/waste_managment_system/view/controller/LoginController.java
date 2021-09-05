package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.waste_managment_system.controller.UserController;
import lk.waste_managment_system.model.User;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private JFXTextField userName_txt;

    @FXML
    private JFXTextField password_txt;

    @FXML
    private JFXButton login_btn;

    private AnchorPane dash;

    private String userName;
    private String password;

    private UserController userController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userController = new UserController();
    }

    @FXML
    void loginButtonAction(ActionEvent event) {
        userName = userName_txt.getText();
        password = password_txt.getText();

        String testPassword = "";
        String testUserName = "";

        try {
            ArrayList<User> user = userController.getName(userName);
            for (User allUser :
                    user) {
                testPassword = allUser.getPassword();
                testUserName = allUser.getUserName();

                System.out.println(testPassword);
                System.out.println(testUserName);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userName.equals(userName) && testPassword.equals(password)) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/MainFrame.fxml"));
                Stage primaryStage = new Stage();
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
                primaryStage.setTitle("Waste Management System");
                ((Stage) (((Button) event.getSource()).getScene().getWindow())).close();
                dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/InfectiousWasteFrame.fxml"));
                MainFrameController.rootPane.getChildren().setAll(dash.getChildren());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Invalied Password");

        }
    }

    @FXML
    void passwordTxtAction(ActionEvent event) {

    }

    @FXML
    void userNameTxtAction(ActionEvent event) {

    }


}
