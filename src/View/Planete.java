package View;

import javafx.geometry.Bounds;
import javafx.scene.shape.Line;

public class Planete {

    private Line sol;
    private Bounds s;
    private final double GRAVITE = 1;

    public Planete(double gravite){
        sol = new Line(0, 700, 1366, 700);
        gravite = this.GRAVITE;
        s = sol.localToScene(sol.getBoundsInLocal());
    }

    public Line getSol() {
        return sol;
    }

    public double getGRAVITE() {
        return GRAVITE;
    }

    public Bounds getS() {
        return s;
    }
}
