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
        System.out.println("    (1) Add Card \n    (2) Update Card \n    (3) Remove Card \n    (4) View All card \n    (5) View a Card  \n    (6) Back ");
        ChoiceUserDeckMenu();
    }
    
     public void ChoiceUserDeckMenu(){
        String choice_user = console.nextLine();
         CardUI card = new CardUI();
        
        if(choice_user.equals("1")){
            JSONObject create_card = card.create_card();
            this.indiv_deck.put(card.pokemon_card_name, create_card);
            PrintDeckMenu(this.indiv_deck);
        }else if(choice_user.equals("2")){

        }else if(choice_user.equals("3")){
           this.indiv_deck.remove(card.select_card());
            PrintDeckMenu(this.indiv_deck);
        }else if(choice_user.equals("4")){
            System.out.println(this.indiv_deck);
            PrintDeckMenu(this.indiv_deck);
        }else if(choice_user.equals("5")){

        }else if(choice_user.equals("6")){
            GameUI game_ui = new GameUI();
            game_ui.PrintMenu();
        }else{
            System.out.println("Bad Selection ");
            ChoiceUserDeckMenu();
        }
    }         
}
