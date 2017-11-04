/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;

import java.util.*;

//import com.sun.java.util.jar.pack.Instruction;
import upmc.pcg.game.*;

import org.json.simple.*;

import java.util.*;

/**
 * @author jerom
 */
public class DeckUI {
    private final Scanner console = new Scanner(System.in);
    private JSONObject indiv_deck;

    public void PrintDeckMenu(JSONObject name_deck) {
        this.indiv_deck = name_deck;
        System.out.println("(1) Add Card \n(2) Update Card \n(3) Remove Card \n(4) View All card \n(5) Search a Card  \n(6) Back ");
        ChoiceUserDeckMenu();
    }

    // TODO Create intermediate method
    public void ChoiceUserDeckMenu() {
        String choice_user = console.nextLine();
        CardUI cardUI = new CardUI();

        if (choice_user.equals("1")) {
            JSONObject create_card = cardUI.create_card();
            if (cardUI.type.equals("Energy Card")) {
                String energy = (String) create_card.get("energy");
                int card_energy = (int) this.indiv_deck.get(energy);
                System.out.println(this.indiv_deck.get(energy));
                this.indiv_deck.remove(energy);
                this.indiv_deck.put(energy, card_energy + 1);

//                System.out.println(this.indiv_deck);


            } else {
                this.indiv_deck.put(cardUI.pokemon_card_name, create_card);
            }

            PrintDeckMenu(this.indiv_deck);
        } else if (choice_user.equals("2")) {
            cardUI.update_card(this.indiv_deck);
        } else if (choice_user.equals("3")) {
            this.indiv_deck.remove(cardUI.select_card());
            PrintDeckMenu(this.indiv_deck);
        } else if (choice_user.equals("4")) {

            System.out.println("Energy cards :");
            cardUI.view_energy_cards(this.indiv_deck);

            System.out.println("Pokemon cards :");
            cardUI.view_pokemon_cards(this.indiv_deck);


            PrintDeckMenu(this.indiv_deck);

        } else if (choice_user.equals("5")) {
            cardUI.search_card(this.indiv_deck);

        } else if (choice_user.equals("6")) {
            GameUI game_ui = new GameUI();
            game_ui.PrintMenu();
        } else {
            System.out.println("Bad Selection ");
            PrintDeckMenu(this.indiv_deck);
        }
    }
}
