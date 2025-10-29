package javadex;

import javafx.application.Application;
import javafx.scene.Scene;
// import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import classes.Pokemon;
import classes.Tipo;
import database.database;
import java.util.List;
import java.util.ArrayList;


/**
 * JavaFX App
 */
public class App extends Application {
     
    private Label label2;
    // private List<Pokemon> pokemons;
    private Pokemon pokemonEscolhido;
    
    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();
        
        database bd = new database();
        bd.inicialize();
        // pokemons = bd.pokemons;
        label2 = new Label("Hello World");
        
        Button pikachu = new Button(bd.buscaPokemon(25).getNome());
        pikachu.setOnAction(e -> atualizacao());
        Label raichu = new Label(bd.buscaPokemon(26).getNome());
       
        StackPane pilha = new StackPane(pikachu);
        ScrollPane tela = new ScrollPane();
        
        VBox listaDePokemons = new VBox();
        for(int i=1; i<=151; i++){         
            listaDePokemons.getChildren().add(new Button(bd.buscaPokemon(i).getNome()));
        }
        tela.setContent(listaDePokemons);
        //vertical.getChildren().add(horizontal);
        
        //Pikachu Raichu (Horizontal)
        var scene = new Scene(tela,  640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
    public void atualizacao(){
        label2 = new Label("Atualizei");
    }

    public static void main(String[] args) {
        launch();
    }

}