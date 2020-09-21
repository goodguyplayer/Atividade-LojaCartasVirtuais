package sample.parsers;
import org.json.JSONObject;
import sample.model.PokemonCard;

/**
 * A class to parse individuals pokemoncards to json
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class PokemonCardParser {

    /**
     * Converts a PokemonCard into Json
     * @param card PokemonCard
     * @return Json
     */
    public static JSONObject toJson(PokemonCard card){
        JSONObject json = new JSONObject();
        json.put("id", card.getId());
        json.put("name", card.getName());
        json.put("imageUrlHiRes", card.getUrl());
        json.put("rarity", card.getRarity());
        json.put("series", card.getSeries());
        json.put("set", card.getSet());
        return json;
    }

    /**
     * Converts a Json into PokemonCard
     * @param json Json
     * @return PokemonCard
     */
    public static PokemonCard fromJson(JSONObject json){
        PokemonCard card = new PokemonCard(
                json.getString("imageUrlHiRes"),
                json.getString("id"),
                json.getString("name"),
                PokemonCardRarityParser.toStatus(json.getString("rarity")),
                json.getString("series"),
                json.getString("set")
        );
        return card;
    }
}
