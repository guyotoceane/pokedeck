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
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import upmc.pcg.game.Game;

public class GameUI {
    private final Game game = new Game();
    private final Scanner console = new Scanner(System.in);
    private ArrayList<Deck> names_decks = new ArrayList<>();;

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
    private void PrintMenu(){
        System.out.println("(1) Create a deck \n(2) View names of all decks \n(3) View a deck \n(4) Leave ");
        ChoiceUserMenu();
    }
    
    private void ChoiceUserMenu(){
        String choice_user = console.nextLine();
        
        if(choice_user.equals("1")){
            CreateDeck();
        }else if(choice_user.equals("2")){
            ViewAllNamesDecks();
        }else if(choice_user.equals("3")){
            ViewDeck();
        }
        else if(choice_user.equals("4")){
            System.exit(0);
        }else{
            System.out.println("Bad Selection ");
            ChoiceUserMenu();
        }
    }
    
    
//Method for Menu    
    public void CreateDeck(){
        System.out.println("Deck's name ? ");     
        String name_deck = console.nextLine();
        
        this.names_decks.add(new Deck(name_deck));  //create a deck in names_decks 
        System.out.println(names_decks.get(0).ViewNameDeck() + " was created");
        PrintMenu();
    }
    
    public void ViewAllNamesDecks(){

        if(names_decks.isEmpty()){
            System.out.println("0 deck create");
        }else{
            System.out.println("List of names of all decks : ");
            for(int i=0; i<names_decks.size(); i++){
                System.out.print(" " + names_decks.get(i).ViewNameDeck() +",");
            }
            System.out.println(" ");
        }
        
        PrintMenu();
    }
    
    public void ViewDeck(){
        System.out.println("What deck you want to see? ");
        String name_deck = console.nextLine();
        
        //Menu deck 
        //Search Card ...
    }
    
}
