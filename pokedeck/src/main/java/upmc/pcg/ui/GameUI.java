// Copyright 2017 Pierre Talbot (IRCAM)

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//     http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package upmc.pcg.ui;

import java.util.*;
import upmc.pcg.game.*;

import org.json.simple.*;


import java.util.ArrayList;


public class GameUI {
    private final Game game = new Game();
    private final Scanner console = new Scanner(System.in);
    public static JSONObject list_decks = new JSONObject();

    public void start() {
        print_welcome_msg();
        ArrayList<String> names = ask_players_names();

        PrintMenu();
        
        game.initialize(names);
        game.play();
    }

    private ArrayList<String> ask_players_names() {
        return new ArrayList<>();
    }

    private void print_welcome_msg() {
          System.out.println("Hello, welcome ! ");
    }

    
    
    
/*Menu*/
    public void PrintMenu(){
        System.out.println("(1) Create a deck \n(2) View names of all decks \n(3) View a deck \n(4) Leave ");
        ChoiceUserMenu();
    }
    
    public void ChoiceUserMenu(){
        String choice_user = console.nextLine();
        CardUI card = new CardUI();

        switch (choice_user){
            case "1" :
                CreateDeck();
                break;
            case "2" :
                ViewAllNamesDecks();
                break;
            case "3" :
                ViewDeck();
                break;
            case "4" :
                System.exit(0);
                break;
            case "5" :
                card.create_card();
                break;
            default:
                System.out.println("Bad Selection ");
                PrintMenu();
                break;

        }
    }
    
    
//Method for Menu    
    public void CreateDeck(){
        System.out.println("Deck's name ? ");     
        String name_deck = console.nextLine();
        Deck deck = new Deck(name_deck);
        deck.new_deck();
//        this.list_decks.put("deck_name", deck);  //create a deck in names_decks
        System.out.println(deck.ViewNameDeck() + " was created");
        PrintMenu();
    }
    
    public void ViewAllNamesDecks(){

        if(list_decks.isEmpty()){
            System.out.println("0 deck create");
        }else{
            System.out.println("List of names of all list_decks : ");

            for (Object keyObject : list_decks.keySet())
            {
                String key = (String)keyObject;
                System.out.print("* " + key +"\n");
            }

        }
        PrintMenu();
    }
    
    public void ViewDeck(){
        System.out.println("What deck you want to see? ");
        JSONObject name_deck = (JSONObject) list_decks.get(console.nextLine());
        if(name_deck != null){
            DeckUI deck_ui = new DeckUI();
            deck_ui.PrintDeckMenu(name_deck);
        } else{
            System.out.println("Deck doesn't exist ...");
            PrintMenu();
        }


        //Menu deck 
        //Search Card ...
    }


}
