package View;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Vaisseau {

    private double vitesseX;
    private double vitesseY;
    private int X;
    private int Y;
    private Rectangle vaisseau;

    public Vaisseau(){
        vaisseau = new Rectangle(50,50, Color.BLACK);
        vaisseau.setX(650);
        vaisseau.setY(50);
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

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
