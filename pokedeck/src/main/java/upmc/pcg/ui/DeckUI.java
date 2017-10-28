/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.ui;
import java.util.*;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author jerom
 */
public class DeckUI {
    private final Scanner console = new Scanner(System.in);
        
    public void PrintDeckMenu(){
        System.out.println("    (1) Add Card \n    (2) UpdateCard \n    (3) Remove Card   \n    (4) Back ");
        ChoiceUserDeckMenu();
    }
    
     public void ChoiceUserDeckMenu(){
        String choice_user = console.nextLine();
        
        if(choice_user.equals("1")){
            
        }else if(choice_user.equals("2")){

        }else if(choice_user.equals("3")){

        }
        else if(choice_user.equals("4")){
            GameUI game_ui = new GameUI();
            game_ui.PrintMenu();
        }else{
            System.out.println("Bad Selection ");
            ChoiceUserDeckMenu();
        }
    }         
}
