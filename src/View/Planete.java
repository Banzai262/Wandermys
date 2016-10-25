package View;

import javafx.scene.shape.Line;

public class Planete {

    private Line sol;
    private final double GRAVITE = 9.8;

    public Planete(double gravite){
        sol = new Line(0, 700, 1366, 700);
        gravite = this.GRAVITE;
    }

    public Line getSol() {
        return sol;
    }

    public double getGRAVITE() {
        return GRAVITE;
    }
}
