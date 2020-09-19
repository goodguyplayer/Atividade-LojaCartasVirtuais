package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

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
        System.out.println("Button clicked");
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
}
