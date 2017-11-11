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
    private JSONObject search = new JSONObject();
    private DeckUI deckUi = new DeckUI();

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

    public String select_card() {
        System.out.println("Card name ? \n");
        return console.nextLine();
    }

    public void update_card(JSONObject deck) {
        System.out.println("**Update a Pokemon Card**");
        String card_name = select_card();
        if (card_name.equals("Water") || card_name.equals("Fighting") || card_name.equals("Psychic") || card_name.equals("Lightning") || card_name.equals("Fire") || card_name.equals("Grass")) {
            System.out.println("Error ! You have choose an Energy Card. It's not possible to update this card ... ");
            update_card(deck);
        } else {
            JSONObject card = (JSONObject) deck.get(card_name);
            if (card != null) {
                System.out.println(view_card_pokemon(card));
                update_option(card, deck);


            } else {
                System.out.println("Error ! You don't have this Pokemon card in the deck ...  ");
                update_card(deck);
            }

        }
    }

    public void update_option(JSONObject card, JSONObject deck) {
        System.out.println("(1)Change name\n(2)Change hp \n(3)Change Pokemon Type\n(4)Finish update");
        switch (console.nextLine()) {
            case "1":
                System.out.println("New name :");
                String name = console.nextLine();
                card.remove("name");
                card.put("name", name);
                update_option(card, deck);
                break;
            case "2":
                System.out.println("New hp :");
                String hp = console.nextLine();
                card.remove("hp");
                card.put("hp", hp);
                update_option(card, deck);
                break;
            case "3":
                PokemonType pokemon_type = new PokemonType();
                energy_type();
                pokemon_type.view_type_color(this.card_energy);
                card.remove("pokemon_type");
                card.put("pokemon_type", this.card_energy);
                card.remove("color");
                card.put("color", PokemonType.color);
                update_option(card, deck);
                break;
            case "4":
                deckUi.print_deck_menu(deck);
            default:
                System.out.println("Bad Selection !");
                update_option(card, deck);
        }
    }

    public String view_card_energy(int card) {
        return "You have " + card + " energy \n";
    }

    public String view_card_pokemon(JSONObject card) {
        return "\033[" + card.get("color") + "m" + "Pokemon Name : " + card.get("name") + "\nhp : " + card.get("hp") + "\nPokemon Type : " + card.get("pokemon_type") + "\033[00m";
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

    private void energy_type() {
        System.out.println("Choise an energy type : \n(1) Grass \n(2) Fire \n(3) Water \n(4) Lightning \n(5) Psychic \n(6) Fighting");
        switch (console.nextLine()) {
            case "1":
                card_energy = "Grass";
                break;
            case "2":
                card_energy = "Fire";
                break;
            case "3":
                card_energy = "Water";
                break;
            case "4":
                card_energy = "Lightning";
                break;
            case "5":
                card_energy = "Psychic";
                break;
            case "6":
                card_energy = "Fighting";
                break;
            default:
                System.out.println("Bad Selection");
                energy_type();
                break;
        }
    }

    public void search_card(JSONObject deck) {
        System.out.println("Card Type : \n(1)Pokemon card\n(2) Energy card");
        String type = console.nextLine();
        switch (type) {
            case "1":
                view_pokemon_cards(deck);
                energy_type();
                search_option(this.search, "pokemon_type", card_energy);
                String name = select_card();
                System.out.println("Final result of your search : ");
                search_option(this.search, "name", name);
                break;
            case "2":
                view_energy_cards(deck);
                energy_type();
                int number = (int) deck.get(card_energy);
                System.out.println("Final result of your search : ");
                System.out.println("-------------------------");
                System.out.println("Energy type : " + card_energy);
                System.out.print(view_card_energy(number));
                System.out.println("-------------------------");
                break;
        }
    }

    public void view_energy_cards(JSONObject deck) {
        System.out.println("-------------------------");
        for (Object keyObject : deck.keySet()) {
            String key = (String) keyObject;

            if (key.equals("Water") || key.equals("Fighting") || key.equals("Psychic") || key.equals("Lightning") || key.equals("Fire") || key.equals("Grass")) {
                int number = (int) deck.get(key);
                System.out.println("Energy type : " + key);
                System.out.print(view_card_energy(number));
                System.out.println("-------------------------");
            }

        }
    }

    public void view_pokemon_cards(JSONObject deck) {
        System.out.println("-------------------------");
        for (Object keyObject : deck.keySet()) {
            String key = (String) keyObject;

            if (!(key.equals("Water") || key.equals("Fighting") || key.equals("Psychic") || key.equals("Lightning") || key.equals("Fire") || key.equals("Grass"))) {
                JSONObject card_name = (JSONObject) deck.get(key);
                System.out.println(view_card_pokemon(card_name));
                System.out.println("-------------------------");
                this.search.put(key, card_name);
            }

        }
    }

    private void search_option(JSONObject deck, String option, String choice) {
        System.out.println("-------------------------");
        JSONObject save_deck = deck;
        this.search = null;
        this.search = new JSONObject();
        for (Object keyObject : save_deck.keySet()) {
            String key = (String) keyObject;
            JSONObject card_name = (JSONObject) save_deck.get(key);
            if (card_name.get(option) != null) {
                if (card_name.get(option).equals(choice)) {
                    System.out.println(view_card_pokemon(card_name));
                    System.out.println("-------------------------");
                    this.search.put(key, card_name);
                }
            } else {
                System.out.println("Bad Selection");
                search_card(deck);
            }


        }
    }
}