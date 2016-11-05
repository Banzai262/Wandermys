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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Optional;

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
                    vit.setTemps2(0);
                    vit.setPressed(true);

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


     /*  scene.setOnKeyPressed(event -> {
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


        Alert fin = new Alert(Alert.AlertType.INFORMATION);

        Timeline stop = new Timeline(
                new KeyFrame(Duration.millis(0.1), b -> {
                    switch (col.checkCollision(v, p, deplacement)) {
                        case 0:
                            fin.setTitle("CRASH");
                            fin.setHeaderText(null);
                            fin.setContentText("Vous vous êtes crashé!!!");
                            try {
                                Optional<ButtonType> result = fin.showAndWait();
                                if (result.get() == ButtonType.OK)
                                    System.exit(0);
                            } catch (Exception e) {
                            }
                            break;
                        case 1:
                            fin.setTitle("SUCCESS");
                            fin.setHeaderText(null);
                            fin.setContentText("Vous avez atterri en toute sécurité!!!");
                            try {
                                Optional<ButtonType> result = fin.showAndWait();
                                if (result.get() == ButtonType.OK)
                                    System.exit(0);
                            } catch (Exception e) {
                            }
                            break;
                    }
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
