package sample.parsers;

import sample.enums.PokemonCardRarity;

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