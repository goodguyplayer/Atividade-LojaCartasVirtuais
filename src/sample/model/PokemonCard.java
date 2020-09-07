package sample.model;

import sample.enums.PokemonCardRarity;

/**
 * <h1>Class PokemonCard</h1>
 * Class made to contain data of a pokemonCard.
 *
 * @author Nathan Brito da Silva - 17.00531-0
 * @version 1.0
 * @since 2020-09-07
 */
public class PokemonCard {
    private String url;
    private String id;
    private String name;
    private PokemonCardRarity rarity;
    private String series;
    private String set;

    /**
     * Constructor
     * @param url Weburl for the image. Using highres urls. String
     * @param id Id for the card. Each card has their own unique id. String
     * @param name Name of the card. String
     * @param rarity Rarity of the card. Enum PokemonCardRarity
     * @param series The series which the card belongs to. String
     * @param set The set in which the card was seen.
     */
    public PokemonCard(String url, String id, String name, PokemonCardRarity rarity, String series, String set) {
        this.url = url;
        this.id = id;
        this.name = name;
        this.rarity = rarity;
        this.series = series;
        this.set = set;
    }

    /**
     * Returns the url of the card
     * @return String
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets an url. String
     * @param url String
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Returns the id of the card
     * @return String
     */
    public String getId() {
        return id;
    }

    /**
     * Sets an id. String
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns the name of the card.
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a name. String
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the rarity type of the card as text.
     * @return String
     */
    public String getRarity() {
        return ""+rarity;
    }

    /**
     * Set a rarity type.
     * @param rarity PokemonCardRarity enum
     */
    public void setRarity(PokemonCardRarity rarity) {
        this.rarity = rarity;
    }

    /**
     * Returns the series of the card.
     * @return String
     */
    public String getSeries() {
        return series;
    }

    /**
     * Set a series for the card.
     * @param series String
     */
    public void setSeries(String series) {
        this.series = series;
    }

    /**
     * Return the set of the card
     * @return String
     */
    public String getSet() {
        return set;
    }

    /**
     * Set a different set for the card.
     * @param set String
     */
    public void setSet(String set) {
        this.set = set;
    }
}
