/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;
import java.util.*;
import upmc.pcg.game.Deck;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author jerom
 */
public class DeckUI {
    private final Scanner console = new Scanner(System.in);
        
    public void PrintDeckMenu(){
        System.out.println("    (1) Add Card \n    (2) Update Card \n    (3) Remove Card \n    (4) View All card \n    (5) View a Card  \n    (6) Back ");
        ChoiceUserDeckMenu();
    }
    
     public void ChoiceUserDeckMenu(){
        String choice_user = console.nextLine();
        
        if(choice_user.equals("1")){
            CardUI card = new CardUI();
            card.AddCard();
             
            
        }else if(choice_user.equals("2")){

        }else if(choice_user.equals("3")){
            System.out.println("Choose a card to delete");
            String choice_card = console.nextLine();
            
            
        }else if(choice_user.equals("4")){

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
