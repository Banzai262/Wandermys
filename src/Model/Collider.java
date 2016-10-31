package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Timeline;

public class Collider {

    public Collider() {
    }

    public void checkCollision(Vaisseau v, Planete p, Timeline tl) {
        if (v.getVai().intersects(p.getS()))
            tl.stop();
    }
}
