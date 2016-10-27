package Model;

import View.Planete;
import View.Vaisseau;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

public class Vitesse {

    private Vaisseau zodiac;
    private Planete p;
    double temps = 0;
    Timeline time;
    private double accel;

    public Vitesse(Vaisseau v) {
        this.zodiac = v;
        time = new Timeline(new KeyFrame(Duration.millis(10), a -> {
            temps = temps + 0.01;
        }));
        p = new Planete(9.8);
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
        setAccel(getP().getGRAVITE());
    }

    public double getAccel() {
        return accel;
    }

    public void setAccel(double accel) {
        this.accel = accel;
    }

    public Vaisseau getZodiac() {
        return zodiac;
    }

    public Planete getP() {
        return p;
    }

    public double calculVitesseY() {
        getZodiac().setVitesseY(getZodiac().getVitesseY() + getAccel() * temps);
        return getZodiac().getVitesseY();
    }

    public double calculPosY(Vaisseau v) {
        double depY = (calculVitesseY() * temps + 0.5 * getAccel() * Math.pow(temps, 2));
        v.setY(v.getY() + depY);
        v.setVai(v.getVaisseau().localToScene(v.getVaisseau().getBoundsInLocal()));
        return depY;
    }

    public void up(Vaisseau v){
        v.getVaisseau().setOnKeyPressed(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode() == KeyCode.K.UP)
                {
                    setAccel(p.getGRAVITE() - 12);
                }
                ke.consume();
            }
        });
    }

    public void down(Vaisseau v){
        v.getVaisseau().setOnKeyReleased(new EventHandler<KeyEvent>()
        {
            @Override
            public void handle(KeyEvent ke)
            {
                if (ke.getCode() == KeyCode.UP)
                {
                    setAccel(p.getGRAVITE());
                }
                ke.consume();
            }
        });
    }
}
