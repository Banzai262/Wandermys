package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;

public class Collider {

    public Collider() {
    }

    public void checkCollision(Vaisseau v, Planete p, Timeline tl) {
        //tl.setCycleCount(Animation.INDEFINITE);
        if (v.getVai().intersects(p.getS()))
            tl.stop();
    }
}
