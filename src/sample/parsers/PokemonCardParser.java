package sample.parsers;
import org.json.JSONObject;
import sample.model.PokemonCard;

public class PokemonCardParser {
    public static JSONObject toJson(PokemonCard card){
        JSONObject json = new JSONObject();
        json.put("id", card.getId());
        json.put("name", card.getName());
        json.put("imageUrl", card.getUrl());
        json.put("rarity", card.getRarity());
        json.put("series", card.getSeries());
        json.put("set", card.getSet());
        return json;
    }

    public static PokemonCard fromJson(JSONObject json){
        PokemonCard card = new PokemonCard(
                json.getString("url"),
                json.getString("id"),
                json.getString("name"),
                PokemonCardRarityParser.toStatus(json.getString("rarity")),
                json.getString("series"),
                json.getString("set")
        );
        return card;
    }
}
