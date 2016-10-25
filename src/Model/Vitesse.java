package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class Vitesse {

    private Vaisseau zodiac;
    private Planete p;
    double temps = 0;
    Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), a -> {
        temps = temps + 0.01;
    }));

    public Vitesse(Vaisseau v){
        this.zodiac = v;
    }

    public Vaisseau getZodiac() {
        return zodiac;
    }

    public Planete getP() {
        return p;
    }

    public void calculVitesseY(){
        getZodiac().setVitesseY(getZodiac().getVitesseY() + getP().getGRAVITE() * temps);
    }
}
