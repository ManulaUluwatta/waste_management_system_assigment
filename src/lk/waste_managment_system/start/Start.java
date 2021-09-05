package lk.waste_managment_system.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Start extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/lk/waste_managment_system/view/fxml/Login.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Waste Management System");
        primaryStage.show();
    }
}


