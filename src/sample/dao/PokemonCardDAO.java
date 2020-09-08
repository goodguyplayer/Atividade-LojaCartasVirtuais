package sample.dao;

import sample.model.PokemonCard;
import sample.model.PokemonCardList;
import sample.parsers.PokemonCardRarityParser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Class PokemonCardDAO</h1>
 * DAO for PokemonCard. Contains a variety of methods made to make usage easier
 * <p>
 * <br>
 *     Version 1.1
 *     - Modified methods get() and getAll(). Removed the list var and added the PokemonCardList.
 *
 *     Version 1.2
 *     - Removed "int retorno = " from create() and update()
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.1
 * @since 2020-09-07
 */
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

    /**
     * Allows for a search in the db with a specified value.
     * Uses method getSelectConditionalString for the query.
     * @param condition Condition for the search.
     * @return Returns list of PokemonCard that meet said condition
     */
    @Override
    public List<PokemonCard> get(String condition) {
        PokemonCardList cardList = new PokemonCardList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectConditionalString(getTableName()) + condition);
            while(result.next()){
                cardList.addCard(new PokemonCard(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("name"),
                        PokemonCardRarityParser.toStatus(result.getString("rarity")),
                        result.getString("series"),
                        result.getString("collectionset")));
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return cardList.getCards();
    }

    /**
     * Allows for a search that returns all items in the database.
     * Uses method getSelectAllString for the query.
     * @return List of PokemonCard in the table
     */
    @Override
    public List<PokemonCard> getAll() {
        PokemonCardList cardList = new PokemonCardList();
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(getSelectAllString(getTableName()));
            while(result.next()){
                cardList.addCard(new PokemonCard(
                        result.getString("url"),
                        result.getString("id"),
                        result.getString("name"),
                        PokemonCardRarityParser.toStatus(result.getString("rarity")),
                        result.getString("series"),
                        result.getString("collectionset")));
            }
            result.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return cardList.getCards();
    }

    /**
     * Method used for updating a card value in the table.
     * Uses method getUpdateString
     * @param pokemonCard Takes a PokemonCard infomation
     */
    @Override
    public void update(PokemonCard pokemonCard) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getUpdateString(getTableName()));
            preparedStatement.setString(1, pokemonCard.getId());
            preparedStatement.setString(2, pokemonCard.getName());
            preparedStatement.setString(3, pokemonCard.getUrl());
            preparedStatement.setString(4, pokemonCard.getRarity());
            preparedStatement.setString(5, pokemonCard.getSeries());
            preparedStatement.setString(6, pokemonCard.getSet());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method used for deleting a card in the table.
     * Uses method getDeleteString
     * @param pokemonCard Takes a PokemonCard infomation
     */
    @Override
    public void delete(PokemonCard pokemonCard) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getDeleteString(getTableName()));
            preparedStatement.setString(1, pokemonCard.getId());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method used to add a card in the table
     * Uses method getInsertString
     * @param pokemonCard Takes a PokemonCard infomation
     */
    @Override
    public void create(PokemonCard pokemonCard) {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getInsertString(getTableName()));
            preparedStatement.setString(1, pokemonCard.getId());
            preparedStatement.setString(2, pokemonCard.getName());
            preparedStatement.setString(3, pokemonCard.getUrl());
            preparedStatement.setString(4, pokemonCard.getRarity());
            preparedStatement.setString(5, pokemonCard.getSeries());
            preparedStatement.setString(6, pokemonCard.getSet());
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Method used to store the name of the table.
     * @return name of the table
     */
    @Override
    public String getTableName() {
        return "pokemoncards";
    }

    /**
     * Used to store the query for deletion
     * @param table Takes table name to write the string
     * @return Query string
     */
    @Override
    public String getDeleteString(String table) {
        return "DELETE FROM "+ table +" WHERE id = ?;";
    }

    /**
     * Used to store the query for update
     * @param table Takes table name to write the string
     * @return Query string
     */
    @Override
    public String getUpdateString(String table) {
        return "UPDATE "+ table +" SET id = ?, name = ?, url = ?, rarity = ?, series = ?, collectionset = ? WHERE id = ?;";
    }

    /**
     * Used to store the query for insertion
     * @param table Takes table name to write the string
     * @return Query string
     */
    @Override
    public String getInsertString(String table) {
        return "INSERT INTO "+ table + " (id, name, url, rarity, series, collectionset) VALUES (?, ?, ?, ?, ?, ?);";
    }

    /**
     * Used to store the query for getting all cards
     * @param table Takes table name to write the string
     * @return Query string
     */
    @Override
    public String getSelectAllString(String table) {
        return "SELECT * FROM " + table;
    }

    /**
     * Used to store the query for condition search
     * @param table Takes table name to write the string
     * @return Query string
     */
    @Override
    public String getSelectConditionalString(String table) {
        return "SELECT * FROM " + table + " WHERE ";
    }
}
