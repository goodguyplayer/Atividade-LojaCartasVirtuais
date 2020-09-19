package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.dao.PokemonCardDAO;
import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

import static sample.enums.PokemonCardRarity.COMMON;

public class Controller {

    @FXML
    public void buttonAdd(Event e){
        System.out.println("Button clicked");
    }

    @FXML
    public void buttonEdit(Event e){
        System.out.println("Button clicked");
    }

    @FXML
    public void buttonRemove(Event e){
        int selectedIndex = PokemonTable.getSelectionModel().getSelectedIndex();
        PokemonCardDAO cardDAO = new PokemonCardDAO();
        if (selectedIndex >= 0) {
            System.out.println(PokemonTable.getItems().get(selectedIndex).getId());
            cardDAO.delete(cardDAO.get("id = \"" + PokemonTable.getItems().get(selectedIndex).getId() + "\"").get(0));
            PokemonTable.getItems().remove(selectedIndex);

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("No Card Selected");
            alert.setContentText("Please select a Card in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private TableView<PokemonCard> PokemonTable;
    @FXML
    private TableColumn<PokemonCard, String> PokemonNameColumn;
    @FXML
    private TableColumn<PokemonCard, String> PokemonSetColumn;

    @FXML
    private Label PokemonNameLabel;
    @FXML
    private Label PokemonIdLabel;
    @FXML
    private Label PokemonURLLabel;
    @FXML
    private Label PokemonRarityLabel;
    @FXML
    private Label PokemonSeriesLabel;
    @FXML
    private Label PokemonSetLabel;

    private Central central;

    private PokemonCardDAO cardDAO = new PokemonCardDAO();

    public Controller() {
    }

    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        PokemonNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        PokemonSetColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSet()));

        showPokemonDetails(null);

        PokemonTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPokemonDetails(newValue));
    }

    private void showPokemonDetails(PokemonCard card) {
        if (card != null) {
            PokemonNameLabel.setText(card.getName());
            PokemonIdLabel.setText(card.getId());
            PokemonURLLabel.setText(card.getUrl());
            PokemonRarityLabel.setText(card.getRarity());
            PokemonSeriesLabel.setText(card.getSeries());
            PokemonSetLabel.setText(card.getSet());


        } else {
            PokemonNameLabel.setText("");
            PokemonIdLabel.setText("");
            PokemonURLLabel.setText("");
            PokemonRarityLabel.setText("");
            PokemonSeriesLabel.setText("");
            PokemonSetLabel.setText("");
        }
    }

    public void setCentral(Central central) {
        this.central = central;

        // Add observable list data to the table
        PokemonTable.setItems(central.getCardData());
    }

    @FXML
    private void handleNewPerson() {
        PokemonCard tempCard = new PokemonCard("","","",COMMON,"","");
        boolean okClicked = central.showCardEditDialog(tempCard);
        if (okClicked) {
            cardDAO.create(tempCard);
            central.getCardData().add(tempCard);
        }
    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
    @FXML
    private void handleEditPerson() {
        PokemonCard selectedCard = PokemonTable.getSelectionModel().getSelectedItem();
        if (selectedCard != null) {
            boolean okClicked = central.showCardEditDialog(selectedCard);
            if (okClicked) {
                cardDAO.update(selectedCard);
                showPokemonDetails(selectedCard);
            }

        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(central.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }
}
