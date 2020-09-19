package sample;

import javafx.beans.property.SimpleStringProperty;
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
    public void buttonClicked(Event e){
        System.out.println("Button clicked");
    }
}
