package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Vitesse {

    private Vaisseau zodiac;
    private Planete p;
    double temps = 0;
    Timeline time;

    public Vitesse(Vaisseau v){
        this.zodiac = v;
        time = new Timeline(new KeyFrame(Duration.millis(10), a -> {
            temps = temps + 0.01;
        }));
        p = new Planete(9.8);
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public Vaisseau getZodiac() {
        return zodiac;
    }

    public Planete getP() {
        return p;
    }

    public double calculVitesseY(){
        getZodiac().setVitesseY(getZodiac().getVitesseY() + getP().getGRAVITE() * temps);
        return getZodiac().getVitesseY();
    }

    public double calculPosY(Vaisseau v) {
        double depY = (calculVitesseY()*temps + 0.5* getP().getGRAVITE() * Math.pow(temps,2));
        v.setY(v.getY() + depY);
        v.setVai(v.getVaisseau().localToScene(v.getVaisseau().getBoundsInLocal()));
        return depY;
    }
}
