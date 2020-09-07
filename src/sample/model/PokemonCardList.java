package sample.model;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>Class PokemonCardList</h1>
 * Class made to act as a list for PokemonCard
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class PokemonCardList {
    private List<PokemonCard> cards;

    /**
     * Constructor.
     * Creates the list.
     */
    public PokemonCardList() {
        this.cards = new ArrayList<>();
    }

    /**
     * Add a PokemonCard to the list
     * @param card PokemonCard
     */
    public void addCard(PokemonCard card){
        this.cards.add(card);
    }

    /**
     * Returns the list of PokemonCards
     * @return List of PokemonCards
     */
    public final List<PokemonCard> getCards() {
        return this.cards;
    }

    /**
     * Returns the entire list as String
     * @return String
     */
    @Override
    public String toString() {
        return "PokemonCardList{" +
                "cards=" + cards +
                '}';
    }


}
