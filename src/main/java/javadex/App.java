package javadex;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import classes.Pokemon;
import classes.Tipo;
import database.database;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        database bd = new database();
        bd.inicialize();

        Label pikachu = new Label(bd.buscaPokemon(25).getNome());
        Label raichu = new Label(bd.buscaPokemon(26).getNome());
        var label2 = new Label("Hello World");
        StackPane pilha = new StackPane(pikachu);
        VBox vertical = new VBox();
        HBox horizontal = new HBox();
        horizontal.getChildren().add(pikachu);
        horizontal.getChildren().add(raichu);
        horizontal.getChildren().add(label2);
        //Hello World
        vertical.getChildren().add(pikachu);
        vertical.getChildren().add(horizontal);
        
        //Pikachu Raichu (Horizontal)
        var scene = new Scene(vertical,  640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}