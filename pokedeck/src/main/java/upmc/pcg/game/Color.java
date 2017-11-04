package upmc.pcg.game;

public class Color {
    private int color;

    public Color(int color){
        this.color = color;
    }

//    public String toString() {
//        return "\033[" + this.color;
//    }
    public String toString() {
        return ""+this.color+"";
    }
}
