package sample.enums;

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
