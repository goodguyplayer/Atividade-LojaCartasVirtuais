package sample.dao;

import sample.model.PokemonCard;
import sample.parsers.PokemonCardRarityParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PokemonCardDAO implements DAO<PokemonCard>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:pokemoncards.db";

    public PokemonCardDAO(){
        try {
            connection = DriverManager.getConnection(myDBConnectionString);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<PokemonCard> get(String condition) {
        List<PokemonCard> cards = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                PokemonCard card = new PokemonCard(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("name"),
                        PokemonCardRarityParser.toStatus(result.getString("rarity")),
                        result.getString("series"),
                        result.getString("set")
                );
                cards.add(card);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return cards;
    }

    @Override
    public List<PokemonCard> getAll() {
        List<PokemonCard> cards = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                PokemonCard card = new PokemonCard(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("name"),
                        PokemonCardRarityParser.toStatus(result.getString("rarity")),
                        result.getString("series"),
                        result.getString("set")
                );
                cards.add(card);
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return cards;
    }


    @Override
    public void update(PokemonCard pokemonCard) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, pokemonCard.getUrl());
            preparedStatement.setString(2, pokemonCard.getId());
            preparedStatement.setString(3, pokemonCard.getName());
            preparedStatement.setString(4, pokemonCard.getRarity());
            preparedStatement.setString(5, pokemonCard.getSeries());
            preparedStatement.setString(6, pokemonCard.getSet());
            int retorno = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void delete(PokemonCard pokemonCard) {

    }

    @Override
    public void create(PokemonCard pokemonCard) {

    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public String getDeleteString(String table) {
        return null;
    }

    @Override
    public String getUpdateString(String table) {
        return null;
    }

    @Override
    public String getInsertString(String table) {
        return null;
    }

    @Override
    public String getSelectAllString(String table) {
        return null;
    }

    @Override
    public String getSelectConditionalString(String table) {
        return null;
    }
}
