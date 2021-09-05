package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;
import lk.waste_managment_system.view.tableView.WasteTableView;

public class InfectiousWasteFrameController {
    @FXML
    private TableView<WasteTableView> infectiousWasteViewTable;

    @FXML
    private TableColumn<WasteTableView, String> wasteId_clm;

    @FXML
    private TableColumn<WasteTableView, String> typeWaste_clm;

    @FXML
    private TableColumn<WasteTableView, String> object_clm;

    @FXML
    private TableColumn<WasteTableView, Integer> typeOfContainer_clm;

    @FXML
    private TableColumn<WasteTableView, Integer> wastePerDay_clm;

    @FXML
    private JFXButton deleteButton;

    @FXML
    private JFXButton loadButton;

    @FXML
    private JFXButton totalWasteDayButton;

    @FXML
    private JFXButton insertDataButton;

    @FXML
    private JFXTextField id_txt;

    @FXML
    private JFXTextField typeOfWaste_txt;

    @FXML
    private JFXTextField wasteObject_txt;

    @FXML
    private JFXTextField typeOfContainer_txt;

    @FXML
    private JFXTextField totalWastePerDay_txt;

    @FXML
    void deleteButtonAction(ActionEvent event) {

    }

    @FXML
    void id_txtAction(ActionEvent event) {

    }

    @FXML
    void insertDataButtonAction(ActionEvent event) {

    }

    @FXML
    void loadButtonAction(ActionEvent event) {

    }

    @FXML
    void totalWasteDayButtonAction(ActionEvent event) {

    }

    @FXML
    void totalWastePerDay_txtAction(ActionEvent event) {

    }

    @FXML
    void typeOfContainer_txtAction(ActionEvent event) {

    }

    @FXML
    void typeOfWaste_txtAction(ActionEvent event) {

    }

    @FXML
    void wasteObject_txtAction(ActionEvent event) {

    }

}
