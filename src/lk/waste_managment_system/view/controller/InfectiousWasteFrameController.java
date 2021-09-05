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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import lk.waste_managment_system.controller.InfectiousWasteController;
import lk.waste_managment_system.model.InfectiousWaste;
import lk.waste_managment_system.other.Validator;
import lk.waste_managment_system.view.tableView.WasteTableView;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class InfectiousWasteFrameController implements Initializable {
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

    private InfectiousWasteController infectiousWasteController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infectiousWasteController = new InfectiousWasteController();
        data = FXCollections.observableArrayList();
        loadInfectiousWaste();
        loadWasteID();
    }

    @FXML
    void deleteButtonAction(ActionEvent event) {
        String wasteID = id_txt.getText();
        try {
            if (infectiousWasteController.deleteInfectiousWaste(wasteID)) {
                JOptionPane.showMessageDialog(null, "Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Delete Failed");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        loadInfectiousWaste();
        clearText();
        loadWasteID();
    }

    @FXML
    void id_txtAction(ActionEvent event) {

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


            InfectiousWaste infectiousWaste = new InfectiousWaste(
                    id_txt.getText(),
                    typeOfWaste_txt.getText(),
                    wasteObject_txt.getText(),
                    Integer.parseInt(typeOfContainer_txt.getText()),
                    Integer.parseInt(totalWastePerDay_txt.getText())

            );

            try {
                Boolean isAdd = infectiousWasteController.updateInfectiousWaste(infectiousWaste);

                if (isAdd) {
                    JOptionPane.showMessageDialog(null, "Successfully Update");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed");
                }

                loadInfectiousWaste();
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


            InfectiousWaste infectiousWaste = new InfectiousWaste(
                    id_txt.getText(),
                    typeOfWaste_txt.getText(),
                    wasteObject_txt.getText(),
                    Integer.parseInt(typeOfContainer_txt.getText()),
                    Integer.parseInt(totalWastePerDay_txt.getText())

            );

            try {
                Boolean isAdd = infectiousWasteController.addInfectiousWaste(infectiousWaste);

                if (isAdd) {
                    JOptionPane.showMessageDialog(null, "Successfully Added");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed");
                }

                loadInfectiousWaste();
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
    void infectiousWasteViewTableAction(MouseEvent event) {
        WasteTableView wasteTableView = infectiousWasteViewTable.getSelectionModel().getSelectedItem();
        id_txt.setText("" + wasteTableView.getWasteID());

        String id = id_txt.getText();


        try {
            List<InfectiousWaste> allInfectiousWaste = infectiousWasteController.getID(id);
            for (InfectiousWaste waste :
                    allInfectiousWaste) {
                typeOfWaste_txt.setText(waste.getTypeOfWaste());
                wasteObject_txt.setText(waste.getObject());
                typeOfContainer_txt.setText(waste.getTypeOfContainer() + "");
                totalWastePerDay_txt.setText(waste.getWastePerDay() + "");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
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
        boolean result = Validator.isNumber(totalWastePerDay_txt.getText());
        if (result) {
            totalWastePerDay_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            totalWastePerDay_txt.setFocusColor(Paint.valueOf("red"));
        }

    }

    @FXML
    void typeOfContainer_txtAction(ActionEvent event) {
        boolean result = Validator.isNumber(typeOfContainer_txt.getText());
        if (result) {
            typeOfContainer_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            typeOfContainer_txt.setFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void typeOfWaste_txtAction(ActionEvent event) {
        boolean result = Validator.isAlpha(typeOfWaste_txt.getText());
        if (result) {
            typeOfWaste_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            typeOfWaste_txt.setFocusColor(Paint.valueOf("red"));
        }

    }

    @FXML
    void wasteObject_txtAction(ActionEvent event) {
        boolean result = Validator.isAlpha(wasteObject_txt.getText());
        if (result) {
            wasteObject_txt.setFocusColor(Paint.valueOf("#4059a9"));
        } else {
            wasteObject_txt.setFocusColor(Paint.valueOf("red"));
        }
    }

    private void loadInfectiousWaste() {
        if (!data.isEmpty()) {
            for (int i = data.size(); i > 0; i--) {
                data.remove(i - 1);
            }
        }


        try {
            List<InfectiousWaste> allInfectiousWaste = infectiousWasteController.view();
            if (allInfectiousWaste != null) {
                for (InfectiousWaste waste :
                        allInfectiousWaste) {
                    data.add(new WasteTableView(
                            waste.getWasteID(),
                            waste.getTypeOfWaste(),
                            waste.getObject(),
                            waste.getTypeOfContainer(),
                            waste.getWastePerDay()
                    ));
                }
            }
            infectiousWasteViewTable.getItems().removeAll();
            wasteId_clm.setCellValueFactory(new PropertyValueFactory("wasteID"));
            typeWaste_clm.setCellValueFactory(new PropertyValueFactory("typeOfWaste"));
            object_clm.setCellValueFactory(new PropertyValueFactory("object"));
            typeOfContainer_clm.setCellValueFactory(new PropertyValueFactory("typeOfContainer"));
            wastePerDay_clm.setCellValueFactory(new PropertyValueFactory("wastePerDay"));

            infectiousWasteViewTable.setItems(data);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadWasteID() {
        try {
            if (infectiousWasteController.getLastId() != null) {
                int lastID = 1 + Integer.parseInt(infectiousWasteController.getLastId());
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
        loadInfectiousWaste();
    }


}
