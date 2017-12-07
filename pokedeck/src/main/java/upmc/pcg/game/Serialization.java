package upmc.pcg.game;

import org.json.simple.JSONObject;
import upmc.pcg.ui.GameUI;

import java.io.*;

public class Serialization implements Serializable {
    private JSONObject deck;
    File fichier =  new File("serializable.ser") ;

    public Serialization(JSONObject deck) throws IOException {
        this.deck = deck;




    }

    public void save() throws IOException {


        ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier)) ;

        try {
            oos.writeObject(this.deck) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open() throws IOException, ClassNotFoundException {

        // ouverture d'un flux sur un fichier
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;

        // désérialization de l'objet
        GameUI.list_decks = (JSONObject) ois.readObject();
    }


}
