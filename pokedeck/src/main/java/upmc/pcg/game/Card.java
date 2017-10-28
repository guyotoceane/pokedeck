package upmc.pcg.game;

public class Card {
    private String card_name;
    private int hp;
    private PokemonType pokemon_type;
    private String type;

    public Card(String pokemon_name, int hp, String type) {
        this.card_name = pokemon_name;
        this.hp = hp;
        this.type = type;


    }

    public String pokemon(){
        this.pokemon_type = new PokemonType();
        this.pokemon_type.view_type_color(this.type);
        return PokemonType.color + "Pokemon Name : "+this.card_name + "\nhp : " + this.hp + "\nPokemon Type : " + PokemonType.pokemon_type;

    }
}
