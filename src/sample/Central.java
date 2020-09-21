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
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.dao.PokemonCardDAO;
import sample.model.PokemonCard;
import sample.model.PokemonCardList;

import java.io.IOException;

/**
 * Main class that runs the application and handles other methods
 */
public class Central extends Application {
    private BorderPane rootLayout;
    private ObservableList<PokemonCard> pokemonCard = FXCollections.observableArrayList();
    private Stage primaryStage;

    /**
     * Main method for execution
     * @param args args
     */
    public void runMe(String[] args){
        launch(args);

    }

    /**
     * Returns the PrimaryStage
     * @return returns the primaryStage
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Used to set the pokemonOverview.fxml and edit.fxml
     * @param primaryStage The stage
     * @throws Exception throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Central.class.getResource("pokemonOverview.fxml"));
            AnchorPane anchorPane = loader.<AnchorPane>load();

            // Give the controller access to the main app.
            Controller controller = loader.getController();
            controller.setCentral(this);

            Scene scene = new Scene(anchorPane);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Used to display the edit dialog segment
     * @param card Takes a PokemonCard.
     * @return Returns whether the ok button was clicked or not
     */
    public boolean showCardEditDialog(PokemonCard card) {
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Central.class.getResource("edit.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Edit Card");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(anchorPane);
            dialogStage.setScene(scene);

            // Set the person into the controller.
            EditController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setCard(card);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * gets all cards from the database to insert in the fxml
     * @return returns the pokemonCard, an ObservableList
     */
    public ObservableList<PokemonCard> getCardData() {
        PokemonCardDAO cardDAO = new PokemonCardDAO();
        for (PokemonCard card: cardDAO.getAll()) {
            pokemonCard.add(card);
        }
        return pokemonCard;
    }
}
