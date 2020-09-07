package sample.dao;

import sample.model.PokemonCard;

import java.sql.Connection;
import java.util.List;

public class PokemonCardDAO implements DAO<PokemonCard>, DAOFields {
    private Connection connection;
    private String myDBConnectionString = "jdbc:sqlite:pokemoncards.db";

    @Override
    public List<PokemonCard> get(String condition) {
        return null;
    }

    @Override
    public List<PokemonCard> getAll() {
        return null;
    }

    @Override
    public void update(PokemonCard pokemonCard) {

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
