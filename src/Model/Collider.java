package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;

public class Collider {

    public Collider() {
    }

    public void checkCollision(Vaisseau v, Planete p, Timeline tl) {
        if (v.getY() + 50 >= p.getSol().getEndY())
            tl.stop();
    }
}
