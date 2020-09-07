package sample.model;

import java.util.ArrayList;
import java.util.List;

public class PokemonCardList {
    private List<PokemonCard> cards;

    public PokemonCardList() {
        this.cards = new ArrayList<>();
    }

    public void addCard(PokemonCard card){
        this.cards.add(card);
    }

    @Override
    public String toString() {
        return "PokemonCardList{" +
                "cards=" + cards +
                '}';
    }

    public final List<PokemonCard> getJogos() {
        return this.cards;
    }
}
