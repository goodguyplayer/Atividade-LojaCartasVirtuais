package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * class made to test and use javaFX
 *
 * Tutorial based on http://tutorials.jenkov.com/javafx/fxml.html
 */
public class JavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Central.class.getResource("sample.fxml"));
        AnchorPane anchorPane = loader.<AnchorPane>load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
