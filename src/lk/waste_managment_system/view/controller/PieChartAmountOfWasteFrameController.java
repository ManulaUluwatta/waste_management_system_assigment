package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import lk.waste_managment_system.controller.InfectiousWasteController;
import lk.waste_managment_system.controller.NonInfectiousWasteController;
import lk.waste_managment_system.model.InfectiousWaste;
import lk.waste_managment_system.model.NonInfectiousWaste;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PieChartAmountOfWasteFrameController implements Initializable {

    @FXML
    private PieChart pieChart;

    @FXML
    private JFXButton loadColorCode_btn;

    private InfectiousWasteController infectiousWasteController;
    private NonInfectiousWasteController nonInfectiousWasteController;

    private ObservableList<PieChart.Data> picChartDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infectiousWasteController = new InfectiousWasteController();
        nonInfectiousWasteController = new NonInfectiousWasteController();
        loadPieChartAmountofWaste();
    }

    @FXML
    void loadColorCodeButtonActio(ActionEvent event) {
        loadPieChartAmountofWaste();

    }

    private void loadPieChartAmountofWaste() {
        double totalInfectiousWaste = 0;
        double totalNonInfectiousWaste = 0;

        pieChart.getData().clear();
        picChartDate = FXCollections.observableArrayList();
        try {
            List<InfectiousWaste> allInfectiousWaste = infectiousWasteController.view();
            List<NonInfectiousWaste> allNonInfectiousWaste = nonInfectiousWasteController.view();
            if (allInfectiousWaste != null) {
                for (InfectiousWaste waste :
                        allInfectiousWaste) {
                    totalInfectiousWaste += waste.getWastePerDay();
                }
            }
            if (allInfectiousWaste != null) {
                for (NonInfectiousWaste waste :
                        allNonInfectiousWaste) {
                    totalNonInfectiousWaste += waste.getWastePerDay();
                }
            }

            ObservableList<PieChart.Data> picChartDate = FXCollections.observableArrayList(
                    new PieChart.Data("Infectious Waste", totalInfectiousWaste),
                    new PieChart.Data("Non Infectious Waste", totalNonInfectiousWaste)
            );

            picChartDate.forEach(
                    data -> data.nameProperty().bind(
                            Bindings.concat(data.getName(), " : ", data.pieValueProperty())
                    )
            );

            pieChart.getData().addAll(picChartDate);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
