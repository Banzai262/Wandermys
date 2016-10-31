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
    private boolean pressed = false;

    public Vitesse(Vaisseau v) {
        this.zodiac = v;
        time = new Timeline(new KeyFrame(Duration.millis(10), a -> {
            temps += 0.01;
        }));
        p = new Planete();
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
        setAccel(getP().getGRAVITE());
    }

    public boolean isPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
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
        if (!this.isPressed()) {
            getZodiac().setVitesseY(getZodiac().getVitesseY() + getP().getGRAVITE() * temps);
            return getZodiac().getVitesseY();
        } else if (this.isPressed()) {
            getZodiac().setVitesseY(getZodiac().getVitesseY() + (getP().getGRAVITE() - 0.15) * temps);
            return getZodiac().getVitesseY();
        } else return 0;
    }

    public double calculPosY(Vaisseau v) {
        if (!this.isPressed()) {
            double depY = (calculVitesseY() * temps + 0.5 * getP().getGRAVITE() * Math.pow(temps, 2));
            v.setY(v.getY() + depY);
            v.setVai(v.getVaisseau().localToScene(v.getVaisseau().getBoundsInLocal()));
            return depY;
        } else if (this.isPressed()) {
            double depY = (calculVitesseY() * temps + 0.5 * (getP().getGRAVITE() - 0.5) * Math.pow(temps, 2));
            v.setY(v.getY() + depY);
            v.setVai(v.getVaisseau().localToScene(v.getVaisseau().getBoundsInLocal()));
            return depY;
        } else return 0;

    }

    public void up(Vaisseau v) {
        v.getVaisseau().setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.K.UP) {
                    setPressed(true);
                }
                ke.consume();
            }
        });
    }

    public void down(Vaisseau v) {
        v.getVaisseau().setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.UP) {
                    setPressed(false);
                }
                ke.consume();
            }
        });
    }
}
