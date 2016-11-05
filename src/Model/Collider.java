package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Timeline;

public class Collider {

    private boolean crash = false;

    public Collider() {
    }

    public int checkCollision(Vaisseau v, Planete p, Timeline tl) {
        if (v.getVai().intersects(p.getS())) {
            tl.stop();
            if (v.getVaisseau().getRotate() > 10 || v.getVaisseau().getRotate() < -10) {
                return 0;
            } else
                return 1;
        }
        return 2;
    }

    public void motFin() {
        if (crash)
            System.out.println("CRASH");
        else System.out.println("SUCCESS");
    }

    public boolean isCrash() {
        return crash;
    }

    public void setCrash(boolean crash) {
        this.crash = crash;
    }
}
