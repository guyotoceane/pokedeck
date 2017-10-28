package upmc.pcg.game;

public class Card {
    private String card_name;
    private int hp;
    private PokemonType pokemon_type;
    private String card_type;

//    public Card(int type) {
//        switch (type) {
//            case 1:
//                this.card_type = "pokemon";
//                break;
//            case 2:
//                this.card_type = "energy";
//                break;
//            default:
//                this.card_type = "pokemon";
//                break;
//        }
//    }

    public String pokemon(String pokemon_name, int hp, String type){
        this.pokemon_type = new PokemonType();
        this.pokemon_type.view_type_color(type);
        return PokemonType.color + "Pokemon Name : "+pokemon_name + "\nhp : " + hp + "\nPokemon Type : " + PokemonType.pokemon_type;

    }
}
