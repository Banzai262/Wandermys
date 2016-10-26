package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vaisseau {

    private double vitesseX;
    private double vitesseY;
    private double X;
    private double Y;
    private Rectangle vaisseau;

    public Vaisseau(){
        vaisseau = new Rectangle(50,50, Color.BLACK);
        vaisseau.setX(650);
        this.setX(vaisseau.getX());
        vaisseau.setY(50);
        this.setY(vaisseau.getY());
        setVitesseX(0);
        setVitesseY(0);
    }

    public Rectangle getVaisseau() {
        return vaisseau;
    }

    public double getVitesseX() {
        return vitesseX;
    }

    public void setVitesseX(double vitesseX) {
        this.vitesseX = vitesseX;
    }

    public double getVitesseY() {
        return vitesseY;
    }

    public void setVitesseY(double vitesseY) {
        this.vitesseY = vitesseY;
    }

    public double getX() {
        return X;
    }

    public void setX(double x) {
        X = x;
    }

    public double getY() {
        return Y;
    }

    public void setY(double y) {
        Y = y;
    }
}
