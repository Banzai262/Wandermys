import Model.Collider;
import Model.Vitesse;
import View.Planete;
import View.Vaisseau;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setTitle("Wandermys");
        Scene scene = new Scene(root, 1366, 768);
        primaryStage.setScene(scene);
        Vaisseau v = new Vaisseau();
        Planete p = new Planete();
        Vitesse vit = new Vitesse(v);
        Collider col = new Collider();

        /*TranslateTransition tt = new TranslateTransition(Duration.millis(15),v.getVaisseau());
        tt.setOnFinished(a -> {
            v.getVaisseau().setTranslateY(vit.calculPosY(v));
        });
        tt.play();*/

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP:
                    vit.setPressed(true);
                    vit.setTemps2(0);
                    break;
                case LEFT:
                    vit.setRotationGauche(true);
                    break;
                case RIGHT:
                    vit.setRotationDroite(true);
                    break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP:
                    vit.setPressed(false);
                    vit.setTemps2(0);
                    break;
                case LEFT:
                    vit.setRotationGauche(false);
                    break;
                case RIGHT:
                    vit.setRotationDroite(false);
                    break;
            }
        });


     /*  scene.setOnKeyPressed(event -> {          //la vitesse ne se reset pas quand le vaisseau change de direction
            if (event.getCode() == KeyCode.UP) {
                vit.setPressed(true);
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                vit.setPressed(false);
            }
        });

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.LEFT){
               vit.setRotationGauche(true);
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.LEFT)
                vit.setRotationGauche(false);
        });

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT){
               vit.setRotationDroite(true);
            }
        });

        scene.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.RIGHT)
                vit.setRotationGauche(false);
        });

        v.getVaisseau().setOnMouseClicked(event ->
                vit.setPressed(true));*/


        Timeline deplacement = new Timeline(
                new KeyFrame(Duration.millis(15), a -> {
                    v.getVaisseau().setTranslateY(vit.calculPosY(v));
                }));
        deplacement.setCycleCount(Animation.INDEFINITE);


        Timeline stop = new Timeline(
                new KeyFrame(Duration.millis(0.1), b -> {
                    col.checkCollision(v, p, deplacement);
                })
        );
        stop.setCycleCount(Animation.INDEFINITE);
        stop.play();
        deplacement.play();

        root.getChildren().addAll(v.getVaisseau(), p.getSol());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
