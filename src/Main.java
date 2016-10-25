import View.Planete;
import View.Vaisseau;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        primaryStage.setTitle("Wandermys");
        primaryStage.setScene(new Scene(root, 1366, 768));
        Vaisseau v = new Vaisseau();
        Planete p = new Planete(9.8);

        root.getChildren().addAll(v.getVaisseau(), p.getSol());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
