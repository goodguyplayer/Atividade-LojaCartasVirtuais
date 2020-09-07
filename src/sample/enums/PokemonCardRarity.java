package sample.enums;

/**
 * <h1>Enum PokemonCardRarity</h1>
 * Possible known types of rarities in the card. Display is set as a string
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public enum PokemonCardRarity {
    COMMON("Common"),
    UNCOMMON("Uncommon"),
    RARE("Rare"),
    RARE_HOLO("Rare holo"),
    RARE_HOLO_EX("Rare holo EX"),
    RARE_ULTRA("Rare Ultra");


    private String display;
    PokemonCardRarity(String display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return display;
    }
}
