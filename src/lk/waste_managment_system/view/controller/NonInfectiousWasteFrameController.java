package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.waste_managment_system.controller.NonInfectiousWasteController;
import lk.waste_managment_system.model.InfectiousWaste;
import lk.waste_managment_system.model.NonInfectiousWaste;
import lk.waste_managment_system.other.Validator;
import lk.waste_managment_system.view.tableView.WasteTableView;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;


public class NonInfectiousWasteFrameController implements Initializable {


    @FXML
    private TableView<WasteTableView> nonInfectiousWasteViewTable;

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
    private JFXButton updateButton;

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

    private ObservableList<WasteTableView> data;

    private NonInfectiousWasteController nonInfectiousWasteController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nonInfectiousWasteController = new NonInfectiousWasteController();
        data = FXCollections.observableArrayList();
        loadNonInfectiousWaste();
        loadWasteID();
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        String wasteID = id_txt.getText();
        try {
            if (nonInfectiousWasteController.deleteNonInfectiousWaste(wasteID)) {
                JOptionPane.showMessageDialog(null, "Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        loadNonInfectiousWaste();
        clearText();
        loadWasteID();
    }

    @FXML
    void id_txtAction(ActionEvent event) {

    }

    @FXML
    void insertDataButtonAction(ActionEvent event) {


        Boolean isValidatorOk = Validator.isNotEmpty(new String[]{
                id_txt.getText(),
                typeOfWaste_txt.getText(),
                wasteObject_txt.getText(),
                typeOfContainer_txt.getText(),
                totalWastePerDay_txt.getText(),

        });
        if (!isValidatorOk) {
            JOptionPane.showMessageDialog(null, "Please fill all text field");
        } else {


            NonInfectiousWaste nonInfectiousWaste = new NonInfectiousWaste(
                    id_txt.getText(),
                    typeOfWaste_txt.getText(),
                    wasteObject_txt.getText(),
                    Integer.parseInt(typeOfContainer_txt.getText()),
                    Integer.parseInt(totalWastePerDay_txt.getText())

            );

            try {
                Boolean isAdd = nonInfectiousWasteController.addNonInfectiousWaste(nonInfectiousWaste);

                if (isAdd) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed");
                }

                loadNonInfectiousWaste();
                clearText();
                loadWasteID();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void updateButtonAction(ActionEvent event) {
        Boolean isValidatorOk = Validator.isNotEmpty(new String[]{
                id_txt.getText(),
                typeOfWaste_txt.getText(),
                wasteObject_txt.getText(),
                typeOfContainer_txt.getText(),
                totalWastePerDay_txt.getText(),

        });
        if (!isValidatorOk) {
            JOptionPane.showMessageDialog(null, "Please fill all text field");
        } else {


            NonInfectiousWaste nonInfectiousWaste = new NonInfectiousWaste(
                    id_txt.getText(),
                    typeOfWaste_txt.getText(),
                    wasteObject_txt.getText(),
                    Integer.parseInt(typeOfContainer_txt.getText()),
                    Integer.parseInt(totalWastePerDay_txt.getText())

            );

            try {
                Boolean isAdd = nonInfectiousWasteController.updateNonInfectiousWaste(nonInfectiousWaste);

                if (isAdd) {
                    JOptionPane.showMessageDialog(null, "Successfully Update");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed");
                }

                loadNonInfectiousWaste();
                clearText();
                loadWasteID();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
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

    private void loadNonInfectiousWaste() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }


        try {
            List<NonInfectiousWaste> allNonInfectiousWaste = nonInfectiousWasteController.view();
            if (allNonInfectiousWaste != null) {
                for (NonInfectiousWaste waste :
                        allNonInfectiousWaste) {
                    data.add(new WasteTableView(
                            waste.getWasteID(),
                            waste.getTypeOfWaste(),
                            waste.getObject(),
                            waste.getTypeOfContainer(),
                            waste.getWastePerDay()
                    ));
                }
            }
            nonInfectiousWasteViewTable.getItems().removeAll();
            wasteId_clm.setCellValueFactory(new PropertyValueFactory("wasteID"));
            typeWaste_clm.setCellValueFactory(new PropertyValueFactory("typeOfWaste"));
            object_clm.setCellValueFactory(new PropertyValueFactory("object"));
            typeOfContainer_clm.setCellValueFactory(new PropertyValueFactory("typeOfContainer"));
            wastePerDay_clm.setCellValueFactory(new PropertyValueFactory("wastePerDay"));

            nonInfectiousWasteViewTable.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadWasteID() {
        try {
            if (nonInfectiousWasteController.getLastId() != null) {
                int lastID = 1 + Integer.parseInt(nonInfectiousWasteController.getLastId());
                id_txt.setText(lastID + "");
            } else {
                id_txt.setText("1");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void clearText() {
        id_txt.setText("");
        typeOfWaste_txt.setText("");
        wasteObject_txt.setText("");
        typeOfContainer_txt.setText("");
        totalWastePerDay_txt.setText("");
        loadNonInfectiousWaste();
    }


}


