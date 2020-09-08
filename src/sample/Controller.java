package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

public class Controller {
    @FXML
    private TableView<PokemonCard> personTable;
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
    @FXML
    private TextField PokemonNameText;
    @FXML
    private TextField PokemonIdText;
    @FXML
    private TextField PokemonURLText;
    @FXML
    private TextField PokemonRarityText;
    @FXML
    private TextField PokemonSeriesText;
    @FXML
    private TextField PokemonSetText;

    private TextField central;

    @FXML
    public void register(){
        PokemonCard usuario = new PokemonCard(
                PokemonURLText.getText(),
                PokemonIdLabel.getText(),
                PokemonNameText.getText(),
                PokemonCardRarityParser.toStatus(PokemonRarityText.getText()),
                PokemonSeriesText.getText(),
                PokemonSetText.getText()
        );
        PokemonURLText.clear();
        PokemonIdText.clear();
        PokemonNameText.clear();
        PokemonRarityText.clear();
        PokemonSeriesText.clear();
        PokemonSetText.clear();
        System.out.println("Usuario Cadastrado:" + usuario);
    }
}
