package lk.waste_managment_system.view.controller;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFrameController implements Initializable {
    @FXML
    private JFXButton infectiousWasteButton;

    @FXML
    private JFXButton nonInfectiousWasteButton;

    @FXML
    private JFXButton pieChartWasteAmountButton;

    @FXML
    private JFXButton infactiousObjectTypeButton;

    @FXML
    private JFXButton infectiousWasteTypeButton;

    @FXML
    private AnchorPane anchorView;

    public static AnchorPane rootPane;

    private AnchorPane dash;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rootPane = anchorView;
    }

    @FXML
    void infactiousObjectTypeButtonAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/PieChartInfectiousObjectFrame.fxml"));
            anchorView.getChildren().setAll(dash.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void infectiousWasteButtonAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/InfectiousWasteFrame.fxml"));
            anchorView.getChildren().setAll(dash.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void infectiousWasteTypeButtonAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/LineChartInfactiousWasteFrame.fxml"));
            anchorView.getChildren().setAll(dash.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void nonInfectiousWasteButtonAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/NonInfectiousWasteFrame.fxml"));
            anchorView.getChildren().setAll(dash.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void pieChartWasteAmountButtonAction(ActionEvent event) {
        try {
            dash = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/PieChartAmountOfWasteFrame.fxml"));
            anchorView.getChildren().setAll(dash.getChildren());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
