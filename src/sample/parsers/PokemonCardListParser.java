package sample.parsers;

import org.json.JSONArray;
import org.json.JSONObject;
import sample.model.PokemonCardList;

public class PokemonCardListParser {
    public static JSONArray toJson(PokemonCardList cardList){
        JSONArray json = new JSONArray();
        cardList.getCards().forEach( card -> {
            json.put(PokemonCardParser.toJson(card));
        });
        return json;
    }

    public static PokemonCardList fromJson(JSONArray json){
        PokemonCardList cardList = new PokemonCardList();
        json.forEach( item ->{
            cardList.addCard(PokemonCardParser.fromJson((JSONObject) item));
        });
        return cardList;
    }
}
