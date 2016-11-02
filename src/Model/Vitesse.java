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
    private double temps = 0;
    Timeline time;
    private double accel;
    private boolean pressed = false;
    private boolean rotationDroite = false;
    private boolean rotationGauche = false;


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

    public boolean isRotationDroite() {
        return rotationDroite;
    }

    public void setRotationDroite(boolean rotationDroite) {
        this.rotationDroite = rotationDroite;
    }

    public boolean isRotationGauche() {
        return rotationGauche;
    }

    public void setRotationGauche(boolean rotationGauche) {
        this.rotationGauche = rotationGauche;
    }

    public void setTemps(double temps) {
        this.temps = temps;
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

    public double calculVitesseY() {       //peut-être enlever le if et mettre tout ça dans la variable accel
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
            if (rotationDroite)
                v.getVaisseau().setRotate(v.getVaisseau().getRotate() + 10);
            if (rotationGauche)
                v.getVaisseau().setRotate(v.getVaisseau().getRotate() - 10);
            return depY;
        } else if (this.isPressed()) {
            double depY = (calculVitesseY() * temps + 0.5 * (getP().getGRAVITE() - 0.5) * Math.pow(temps, 2));
            v.setY(v.getY() + depY);
            v.setVai(v.getVaisseau().localToScene(v.getVaisseau().getBoundsInLocal()));
            if (rotationDroite)
                v.getVaisseau().setRotate(v.getVaisseau().getRotate() + 10);
            if (rotationGauche)
                v.getVaisseau().setRotate(v.getVaisseau().getRotate() - 10);
            return depY;
        } else return 0;
    }
}
