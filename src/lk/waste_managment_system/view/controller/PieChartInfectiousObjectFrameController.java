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

public class PieChartInfectiousObjectFrameController implements Initializable {
    @FXML
    private PieChart pieChart;
    @FXML
    private JFXButton loadColorCode_btn;
    private InfectiousWasteController infectiousWasteController;


    private ObservableList<PieChart.Data> picChartDate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infectiousWasteController = new InfectiousWasteController();
        loadPieChartObjectType();
    }

    @FXML
    void loadColorCodeButtonActio(ActionEvent event) {
        loadPieChartObjectType();
    }

    private void loadPieChartObjectType() {
        pieChart.getData().clear();

        picChartDate = FXCollections.observableArrayList();
        try {
            List<InfectiousWaste> allInfectiousWaste = infectiousWasteController.view();
            if (allInfectiousWaste != null) {
                for (InfectiousWaste waste :
                        allInfectiousWaste) {
                    picChartDate.add(new PieChart.Data(waste.getObject(), waste.getWastePerDay()));
                }
            }

//            ObservableList<PieChart.Data> picChartDate = FXCollections.observableArrayList(
//                    new PieChart.Data("dsajdlsk", 3),
//                    new PieChart.Data("dsajdlsk", 23),
//                    new PieChart.Data("dsajdlsk", 10),
//                    new PieChart.Data("dsajdlsk", 5),
//                    new PieChart.Data("dsajdlsk", 33)
//            );

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
