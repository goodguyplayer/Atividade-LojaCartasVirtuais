package sample.test;

import sample.dao.PokemonCardDAO;
import sample.model.PokemonCard;

/**
 * <h1> Class ReadTableData</h1>
 * <h3>Made for test</h3>
 * Originally made to test the PokemonCardDAO's data gathering and possibly optimize PokemonCardDAO
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-08
 */
public class ReadTableData {
    public static void main(String[] args) {
        PokemonCardDAO cardDAO = new PokemonCardDAO();
        System.out.println("All registered pokemons.");
        for (PokemonCard card: cardDAO.getAll()) {
            System.out.println("-------------------------");
            System.out.println("Pokemon.: " + card.getName());
            System.out.println("Set.: " + card.getSet());
            System.out.println("Url.: " + card.getUrl());
            System.out.println("ID.: " + card.getId());
            cardDAO.update(card);
        }
        System.out.println("-------------------------");

    }
}
