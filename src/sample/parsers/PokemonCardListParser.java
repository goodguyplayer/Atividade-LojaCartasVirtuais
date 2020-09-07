package sample.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import sample.model.PokemonCardList;

/**
 * <h1>Class PokemonCardListParser</h1>
 * A class to parse the PokemonCardParser, when used with json
 *
 * @deprecated It was used only to assist in filling the database. May be removed or kept if future versions include API calls
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class PokemonCardListParser {

    /**
     * Takes a list pokemoncardlist to convert into json
     * @param cardList PokemonCardList
     * @return Json
     */
    public static JSONArray toJson(PokemonCardList cardList){
        JSONArray json = new JSONArray();
        cardList.getCards().forEach( card -> {
            json.put(PokemonCardParser.toJson(card));
        });
        return json;
    }

    /**
     * Takes a json array and convert it into a pokemoncardlist
     * @param json
     * @return PokemonCardList
     */
    public static PokemonCardList fromJson(JSONArray json){
        PokemonCardList cardList = new PokemonCardList();
        json.forEach( item ->{
            cardList.addCard(PokemonCardParser.fromJson((JSONObject) item));
        });
        return cardList;
    }
}
