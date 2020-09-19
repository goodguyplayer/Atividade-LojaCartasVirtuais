package sample;

import javafx.beans.property.SimpleStringProperty;
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


}
