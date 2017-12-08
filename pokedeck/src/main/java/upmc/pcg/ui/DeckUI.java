/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;

import java.util.*;

//import com.sun.java.util.jar.pack.Instruction;

import org.json.simple.*;
import upmc.pcg.game.Card;

/**
 * @author jerom
 */
public class DeckUI {
    private final Scanner console = new Scanner(System.in);
    private JSONObject indiv_deck;

    public void print_deck_menu(JSONObject name_deck) {
        this.indiv_deck = name_deck;
        System.out.println("(1) Add Card \n(2) Update Card \n(3) Remove Card \n(4) View All card \n(5) Search a Card  \n(6) Back ");
        choice_user_deck_menu();
    }

    public void choice_user_deck_menu() {
        String choice_user = console.nextLine();
        CardUI cardUI = new CardUI();

        switch (choice_user) {
            case "1":
                add_card(cardUI);
                break;
            case "2":
                cardUI.update_card(this.indiv_deck);
                break;
            case "3":
                remove_card(cardUI);
                break;
            case "4":
                view_all_card(cardUI);
                break;
            case "5":
                cardUI.search_card(this.indiv_deck);
                break;
            case "6":
                back();
                break;
            default:
                System.out.println("Bad Selection ");
                print_deck_menu(this.indiv_deck);
                break;
        }
    }

    public void add_card(CardUI cardUI) {
        JSONObject create_card = cardUI.create_card();
        if (cardUI.type.equals("Energy Card")) {
            String energy = (String) create_card.get("energy");
            int card_energy = (int) this.indiv_deck.get(energy);
            System.out.println(this.indiv_deck.get(energy));
            this.indiv_deck.remove(energy);
            this.indiv_deck.put(energy, card_energy + 1);
        } else {
            this.indiv_deck.put(cardUI.pokemon_card_name, create_card);
        }

        print_deck_menu(this.indiv_deck);
    }

    public void remove_card(CardUI cardUI) {
        this.indiv_deck.remove(cardUI.select_card());
        print_deck_menu(this.indiv_deck);
    }

    public void view_all_card(CardUI cardUI) {
        System.out.println("Energy cards :");
        cardUI.view_energy_cards(this.indiv_deck);

        System.out.println("Pokemon cards :");
        cardUI.view_pokemon_cards(this.indiv_deck);


        print_deck_menu(this.indiv_deck);
    }

    public void back() {
        GameUI game_ui = new GameUI();
        game_ui.print_menu();
    }

}
