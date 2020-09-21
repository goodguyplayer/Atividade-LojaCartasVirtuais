package sample.test;

import sample.dao.PokemonCardDAO;
import sample.enums.PokemonCardRarity;
import sample.model.PokemonCard;
import sample.model.PokemonCardList;
import sample.parsers.PokemonCardRarityParser;

import java.util.List;

/**
 * -Made for test-.
 * Originally made to test the PokemonCardDAO's data gathering and possibly optimize PokemonCardDAO
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-08
 */
public class ReadTableData {
    public static void main(String[] args) {
        PokemonCardDAO cardDAO = new PokemonCardDAO();

        // getAll - Successfully ran
        /*
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
         */


        // Removal - Successfully ran
        /*
        for (PokemonCard card: cardDAO.getAll()) {
            cardDAO.delete(card);
        }
        */

        // get - Succesfully ran - Eevee best pokemon btw
        /*
        String test = "base2-12";
        List<PokemonCard> vaporeon = cardDAO.get("id= \""+ test +"\" ");
        System.out.println("Which pokemon is the second best?");
        System.out.println(vaporeon.get(0).getName());
         */

        // update - Succesfully ran
        /*
        String test = "base1-14";
        List<PokemonCard> toUpdate = cardDAO.get("id= \""+ test +"\" ");
        toUpdate.get(0).setName("Pikachu will never be raichu");
        cardDAO.update( toUpdate.get(0) );

        System.out.println(cardDAO.get("id= \""+ test +"\" ").get(0).getName());
         */



    }
}
