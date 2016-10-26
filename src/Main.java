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
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Wandermys");
        primaryStage.setScene(new Scene(root, 1366, 768));
        Vaisseau v = new Vaisseau();
        Planete p = new Planete(9.8);
        Vitesse vit = new Vitesse(v);
        Collider col = new Collider();

        Timeline deplacement = new Timeline(
                new KeyFrame(Duration.millis(10), a -> {  //le y du vaisseau ne se change jamais, il est toukours le meme
                    v.getVaisseau().setTranslateY(vit.calculPosY(v));
                }));
        deplacement.setCycleCount(Animation.INDEFINITE);
        deplacement.play();

        Timeline stop = new Timeline(
                new KeyFrame(Duration.millis(10), b -> {
                    col.checkCollision(v, p, deplacement);
                })
        );
        stop.setCycleCount(Animation.INDEFINITE);
        stop.play();



        root.getChildren().addAll(v.getVaisseau(), p.getSol());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
