package View;

import javafx.geometry.Bounds;
import javafx.scene.shape.Line;

public class Planete {

    private Line sol;
    private Bounds s;
    private final double GRAVITE = 0.1;

    public Planete(){
        sol = new Line(0, 700, 1366, 700);
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
