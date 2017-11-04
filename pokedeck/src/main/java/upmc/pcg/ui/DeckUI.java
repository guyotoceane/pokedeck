/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;
import java.util.*;
import upmc.pcg.game.*;

import org.json.simple.*;
import java.util.*;

/**
 *
 * @author jerom
 */
public class DeckUI {
    private final Scanner console = new Scanner(System.in);
    private JSONObject indiv_deck;
    private ArrayList<Deck> deck = new ArrayList();
        
    public void PrintDeckMenu(JSONObject name_deck){
        this.indiv_deck = name_deck;
        System.out.println("(1) Add Card \n(2) Update Card \n(3) Remove Card \n(4) View All card \n(5) View a Card  \n(6) Back ");
        ChoiceUserDeckMenu();
    }
    
     public void ChoiceUserDeckMenu(){
        String choice_user = console.nextLine();
         CardUI cardUI = new CardUI();
        
        if(choice_user.equals("1")){
            JSONObject create_card = cardUI.create_card();
            if(cardUI.type.equals("Energy Card")){
                String energy = (String) create_card.get("energy");
                int card_energy = (int) this.indiv_deck.get(energy);
                System.out.println(this.indiv_deck.get(energy));
                this.indiv_deck.remove(energy);
                this.indiv_deck.put(energy, card_energy+1);

//                System.out.println(this.indiv_deck);


            } else{
                this.indiv_deck.put(cardUI.pokemon_card_name, create_card);
            }

            PrintDeckMenu(this.indiv_deck);
        }else if(choice_user.equals("2")){
            cardUI.update_card(this.indiv_deck);
        }else if(choice_user.equals("3")){
           this.indiv_deck.remove(cardUI.select_card());
            PrintDeckMenu(this.indiv_deck);
        }else if(choice_user.equals("4")){
            System.out.println("-------------------------");
            for (Object keyObject : this.indiv_deck.keySet())
            {
                String key = (String) keyObject;

                if(key.equals("Water") || key.equals("Fighting") || key.equals("Psychic") || key.equals("Lightning") || key.equals("Fire") || key.equals("Grass")){
                    int deck = (int)this.indiv_deck.get(key);
                    System.out.println("Energy type : " + key);
                    System.out.print(cardUI.view_card_energy(deck));
                }
                else {
                    JSONObject deck = (JSONObject) this.indiv_deck.get(key);
                    System.out.println(cardUI.view_card_pokemon(deck));
                }
                System.out.println("-------------------------");

            }

            PrintDeckMenu(this.indiv_deck);

        }else if(choice_user.equals("5")){
            System.out.println("Card Name :");
            String search = console.nextLine();
            JSONObject card_name = (JSONObject) this.indiv_deck.get(search);

            if(this.indiv_deck.get(search) != null){
                System.out.println("-------------------------");
                if(search.equals("Water") || search.equals("Fighting") || search.equals("Psychic") || search.equals("Lightning") || search.equals("Fire") || search.equals("Grass")){
                    System.out.println("Energy type : " + search);
                    System.out.print(cardUI.view_card_energy( (int) this.indiv_deck.get(search)));
                }
                else {
                    System.out.println(cardUI.view_card_pokemon(card_name));
                }
                System.out.println("-------------------------");
                PrintDeckMenu(this.indiv_deck);
            } else{
                System.out.println("Card doesn't exist ...");
                PrintDeckMenu(this.indiv_deck);
            }


        }else if(choice_user.equals("6")){
            GameUI game_ui = new GameUI();
            game_ui.PrintMenu();
        }else{
            System.out.println("Bad Selection ");
            PrintDeckMenu(this.indiv_deck);
        }
    }         
}
