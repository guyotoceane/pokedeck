package upmc.pcg.game;

public class PokemonType {
    public static Color color;

    public void view_type_color(String type) {
        switch (type) {
            case "Grass":
                color = new Color("green");
                break;
            case "Fire":
                color = new Color("red");
                break;
            case "Water":
                color = new Color("blue");
                break;
            case "Lightning" :
                color = new Color("yellow");
                break;
            case "Psychic" :
                color = new Color("purple");
                break;
            case "Fighting" :
                color = new Color("orange");
                break;
            default: color = null;
        }

    }
}
