import Model.Collider;
import Model.Vitesse;
import View.Planete;
import View.Vaisseau;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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
        primaryStage.setScene(new Scene(root, 1366, 768));
        Vaisseau v = new Vaisseau();
        Planete p = new Planete();
        Vitesse vit = new Vitesse(v);
        Collider col = new Collider();


        v.getVaisseau().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                vit.setPressed(true);
            }
        });

        v.getVaisseau().setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                vit.setPressed(false);
            }
        });

        v.getVaisseau().setOnMouseClicked(event ->
                vit.setPressed(true));


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
        v.getVaisseau().requestFocus();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
