package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class LoginController {
    @FXML
    private JFXTextField userName_txt;

    @FXML
    private JFXTextField password_txt;

    @FXML
    private JFXButton login_btn;

    private AnchorPane dash;

    private String userName;
    private String password;

    @FXML
    void loginButtonAction(ActionEvent event) {
        userName = userName_txt.getText();
        password = password_txt.getText();

        if (userName.equals("admin") && password.equals("admin")) {
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
            JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
        }
    }

    @FXML
    void passwordTxtAction(ActionEvent event) {

    }

    @FXML
    void userNameTxtAction(ActionEvent event) {

    }
}
