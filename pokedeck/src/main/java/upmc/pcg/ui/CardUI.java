package upmc.pcg.ui;
import org.json.simple.JSONObject;
import upmc.pcg.game.*;
import java.util.*;

public class CardUI {
    private Scanner console = new Scanner(System.in);
    public String type;
    private String card_energy;
    public String pokemon_card_name;
    private int pokemon_card_hp;

    public JSONObject create_card() {
        System.out.println("**Add a new Card**");
        System.out.println("Type of card : \n(1) Pokemon Card \n(2) Energy Card");
        switch (console.nextLine()) {
            case "1":
                type = "Pokemon Card";
                return pokemon_card();
            case "2":
                type = "Energy Card";
                return energy_card();

            default:
                System.out.println("Bad Selection");
                return create_card();
        }
    }

    public String select_card(){
        System.out.println("Card name ? \n");
        return console.nextLine();
    }

    public String view_card_energy(int card) {
        return "You have "+card+" energy \n";
    }

    public String view_card_pokemon(JSONObject card) {
        return "\033[" +card.get("color") + "m" + "Pokemon Name : "+card.get("name") + "\nhp : " + card.get("hp") + "\nPokemon Type : " + card.get("pokemon_type") + "\033[00m";
    }

    private JSONObject pokemon_card() {
        energy_type();
        System.out.println("Pokemon name :");
        pokemon_card_name = console.nextLine();
        System.out.println("Pokemon hp :");
        pokemon_card_hp = Integer.parseInt(console.nextLine());
        System.out.println();
        Card card = new Card(pokemon_card_name, pokemon_card_hp, card_energy);
        return card.pokemon();
    }

    private JSONObject energy_card() {
        JSONObject energy = new JSONObject();
        energy_type();
        energy.put("energy", card_energy);
        return energy;
    }

    private void energy_type(){
        System.out.println("Choise an energy type : \n(1) Grass \n(2) Fire \n(3) Water \n(4) Lightning \n(5) Psychic \n(6) Fighting");
        switch (console.nextLine()){
            case "1" :
                card_energy = "Grass";
                break;
            case "2" :
                card_energy = "Fire";
                break;
            case "3" :
                card_energy = "Water";
                break;
            case "4" :
                card_energy = "Lightning";
                break;
            case "5" :
                card_energy = "Psychic";
                break;
            case "6" :
                card_energy = "Fighting";
                break;
            default:
                System.out.println("Bad Selection");
                energy_type();
                break;
        }
    }
}