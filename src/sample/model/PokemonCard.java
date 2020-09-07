package sample.model;

import sample.enums.PokemonCardRarity;

public class PokemonCard {
    private String url;
    private String id;
    private String name;
    private PokemonCardRarity rarity;
    private String series;
    private String set;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRarity() {
        return ""+rarity;
    }

    public void setRarity(PokemonCardRarity rarity) {
        this.rarity = rarity;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }
}
