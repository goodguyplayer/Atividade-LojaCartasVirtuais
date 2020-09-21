package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

/**
 * class used as controller for edit.fxml
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-19
 */
public class EditController {
    @FXML
    private TextField Name;
    @FXML
    private TextField ID;
    @FXML
    private TextField URL;
    @FXML
    private TextField Rarity;
    @FXML
    private TextField Series;
    @FXML
    private TextField Set;

    private Stage dialogStage;
    private PokemonCard card;
    private boolean okClicked = false;

    @FXML
    private void initialize() {
    }

    /**
     * Sets the dialog stage
     * @param dialogStage Takes the Stage as a param
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the card
     * @param card Takes a pokemonCard as param
     */
    public void setCard(PokemonCard card) {
        this.card = card;

        Name.setText(card.getName());
        ID.setText(card.getId());
        URL.setText(card.getUrl());
        Rarity.setText(card.getRarity());
        Series.setText(card.getSeries());
        Set.setText(card.getSet());
    }

    /**
     * Checks whether the button "ok" is clicked
     * @return Returns whether okClicked is true or false
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Handles the situation when the user cancels
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }


    /**
     * Handles the situation when the user clicks okay
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            card.setName(Name.getText());
            card.setId(ID.getText());
            card.setUrl(URL.getText());
            card.setRarity(PokemonCardRarityParser.toStatus(Rarity.getText()));
            card.setSeries(Series.getText());
            card.setSet(Set.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Checks to see if input is valid. Else throw a message saying that there's an error
     * @return returns a boolean value
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (Name.getText() == null || Name.getText().length() == 0) {
            errorMessage += "No valid card name!\n";
        }
        if (ID.getText() == null || ID.getText().length() == 0) {
            errorMessage += "No valid ID!\n";
        }
        if (URL.getText() == null || URL.getText().length() == 0) {
            errorMessage += "No valid URL!\n";
        }
        if (Rarity.getText() == null || Rarity.getText().length() == 0) {
            errorMessage += "No valid rarity!\n";
        }
        if (Series.getText() == null || Series.getText().length() == 0) {
            errorMessage += "No valid Series!\n";
        }
        if (Set.getText() == null || Set.getText().length() == 0) {
            errorMessage += "No valid set!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

}
