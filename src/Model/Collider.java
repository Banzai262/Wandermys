package Model;

import View.Vaisseau;
import javafx.animation.Timeline;
import javafx.scene.shape.Line;

public class Collider {

    public Collider(){}

    public void checkCollision(Vaisseau v, Line l, Timeline tl){
        if (v.getY() + 50 == 700)
            tl.stop();
    }

}
