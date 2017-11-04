package upmc.pcg.game;

import org.json.simple.JSONObject;

public class Card {
    private String card_name;
    private int hp;
    private PokemonType pokemon_type;
    private String type;
    private JSONObject card = new JSONObject();

    public Card(String pokemon_name, int hp, String type) {
        this.card_name = pokemon_name;
        this.hp = hp;
        this.type = type;
    }

    public JSONObject pokemon(){
        this.pokemon_type = new PokemonType();
        this.pokemon_type.view_type_color(this.type);
        pokemon_card();
        return this.card;
    }

    public void pokemon_card() {
        card.put("name", this.card_name);
        card.put("hp", this.hp);
        card.put("pokemon_type", PokemonType.pokemon_type);
        card.put("color", PokemonType.color);
    }

}
