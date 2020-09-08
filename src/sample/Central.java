package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.model.PokemonCard;
import sample.model.PokemonCardList;

import java.io.IOException;

public class Central extends Application {
    private BorderPane rootLayout;
    private ObservableList<PokemonCard> pokemonCard = FXCollections.observableArrayList();
    private Stage primaryStage;

    public void runMe(String[] args){
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        this.primaryStage.setTitle("Hello World");
        //primaryStage.setScene(new Scene(root, 300, 600));
        //primaryStage.show();

        initRootLayout();
        getPokemonData();

    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Central.class.getResource("sample.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showController() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Central.class.getResource("pokemonOverview.fxml"));
            AnchorPane pokemonOverview = (AnchorPane) loader.load();

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setCentral(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<PokemonCard> getPokemonData() {
        pokemonCard.addAll();
        return pokemonCard;
    }
}
