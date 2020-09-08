package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

public class Controller {
    @FXML
    private TableView<PokemonCard> PokemonTable;
    @FXML
    private TableColumn<PokemonCard, String> PokemonNameColumn;

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

    private void initialize() {
        PokemonNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
    }

    public void setCentral(Central central) {
        this.central = central;

        // Add observable list data to the table
        //PokemonTable.setItems(central.get());
    }
}
