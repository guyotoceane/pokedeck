/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package upmc.pcg.game;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jerom
 */
public class Deck {
    private List deck = new LinkedList();
    
    
    public Deck() {
        

    }
    
    public void Search() {
        
    }
    
    
    
    
    public void ViewDeck(){
        for(int i = 0; i < deck.size(); i++){
            System.out.println("carte n' " + i + " : " + deck.get(i));
        }
    }
}
