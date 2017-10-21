package upmc.pcg.game;

public class PokemonType {
    public static Color color;
    public static String pokemon_type;

    public void view_type_color(String type) {
        pokemon_type = type;
        switch (pokemon_type) {
            case "Grass":
                color = new Color(32);
                break;
            case "Fire":
                color = new Color(31);
                break;
            case "Water":
                color = new Color(34);
                break;
            case "Lightning" :
                color = new Color(33);
                break;
            case "Psychic" :
                color = new Color(35);
                break;
            case "Fighting" :
                color = new Color(31);
                break;
            default: color = null;
        }

    }
}
