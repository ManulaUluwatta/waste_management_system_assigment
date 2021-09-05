package lk.waste_managment_system.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import lk.waste_managment_system.controller.InfectiousWasteController;
import lk.waste_managment_system.controller.NonInfectiousWasteController;
import lk.waste_managment_system.model.InfectiousWaste;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class LineChartInfectiousWasteFrameController implements Initializable {

    @FXML
    private LineChart<String, Integer> lineChartInfectiousWaste;

    @FXML
    private JFXButton loadLineChart_btn;

    private InfectiousWasteController infectiousWasteController;
    private NonInfectiousWasteController nonInfectiousWasteController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        infectiousWasteController = new InfectiousWasteController();
        nonInfectiousWasteController = new NonInfectiousWasteController();

        lineChartInfectiousWaste.getData().clear();
    }

    @FXML
    void loadLineChartButtonAction(ActionEvent event) {
        lineChartInfectiousWaste.getData().clear();
        XYChart.Series series = new XYChart.Series<String, Double>();


        try {
            List<InfectiousWaste> allInfectiousWaste = infectiousWasteController.view();
            if (allInfectiousWaste != null) {
                for (InfectiousWaste waste :
                        allInfectiousWaste) {
                    series.getData().add(new XYChart.Data<String, Integer>(waste.getObject(), waste.getWastePerDay()));
                }
            }

            series.setName("Infectious type of waste");
            lineChartInfectiousWaste.getData().addAll(series);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
