package sample.parsers;

import sample.enums.PokemonCardRarity;

/**
 * Parses a string and returns the correct enum type.
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class PokemonCardRarityParser {
    public static PokemonCardRarity toStatus(String rarity){
        if(rarity.equals("Uncommon")) return PokemonCardRarity.UNCOMMON;
        if(rarity.equals("Rare")) return PokemonCardRarity.RARE;
        if(rarity.equals("Rare holo")) return PokemonCardRarity.RARE_HOLO;
        if(rarity.equals("Rare holo EX")) return PokemonCardRarity.RARE_HOLO_EX;
        if(rarity.equals("Rare Ultra")) return PokemonCardRarity.RARE_ULTRA;
        else return PokemonCardRarity.COMMON;
    }
}