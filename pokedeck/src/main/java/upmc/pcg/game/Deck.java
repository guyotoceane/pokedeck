/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.LinkedList;
import java.util.List;
import org.json.simple.*;
import upmc.pcg.ui.GameUI;

/**
 *
 * @author jerom
 */
public class Deck {
    private List deck = new LinkedList();
    private String name_deck;
    private JSONObject cards = new JSONObject();
    private JSONObject nbEnergy = new JSONObject();

    public Deck(String name_deck) {
        this.name_deck=name_deck;
    }

    public void new_deck(){

        GameUI.list_decks.put(this.name_deck, cards);
        cards.put("Grass", 0);
        cards.put("Fire", 0);
        cards.put("Water", 0);
        cards.put("Lightning", 0);
        cards.put("Psychic", 0);
        cards.put("Fighting", 0);
    }
    
    
    public String view_name_deck(){
        return this.name_deck;
    }
    
    public void ViewDeck(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println("carte n' " + i + " : " + deck.get(i));
        }
    }

}
