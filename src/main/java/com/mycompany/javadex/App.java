package com.mycompany.javadex;

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
import javafx.scene.image.*;


/**
 * JavaFX App
 */
public class App extends Application {
     // Variaveis Globais
    private Label poke;
    private Pokemon pokemonEscolhido;
    private Label tipos;
    private Label evolucao;
    
    @Override
    public void start(Stage stage) {
        database bd = new database();
        bd.inicialize();
        
        poke = new Label("00 - Tela Inicial");
        tipos = new Label("Tipos vem aqui");
        evolucao = new Label("Evolucao vem aqui");

        VBox listaDePokemons = new VBox();
        for(int i=1; i<=151; i++){
            Pokemon laco_repeticao = bd.buscaPokemon(i);
            Button botao = new Button (laco_repeticao.getNome());
            botao.setOnAction(e->atualizacao(laco_repeticao));
            listaDePokemons.getChildren().add(botao);
        }
        ScrollPane scroll_lista = new ScrollPane();
        scroll_lista.setContent(listaDePokemons);
        
        Image obj = new Image(getClass().getResourceAsStream("/image/051.png"));
        ImageView iv = new ImageView(obj);
        iv.setFitWidth(200); //Largura para 200px
        iv.setPreserveRatio(true); // Manter Dimensões
        
        HBox tela_principal = new HBox();
        tela_principal.getChildren().add(scroll_lista);
        VBox apresentacao = new VBox();
        apresentacao.getChildren().add(poke);
        apresentacao.getChildren().add(iv);
        
        HBox informacoes = new HBox();
        VBox tipos_tela = new VBox();
        tipos_tela.getChildren().add(tipos);        
        VBox evolucao_tela = new VBox();
        evolucao_tela.getChildren().add(evolucao);
        
        informacoes.getChildren().add(tipos_tela);
        informacoes.getChildren().add(evolucao_tela);
        apresentacao.getChildren().add(informacoes);
        tela_principal.getChildren().add(apresentacao);
        var scene = new Scene(tela_principal,  640, 480);
        stage.setScene(scene);
        stage.show();
    }
    public void atualizacao(Pokemon p){
        poke.setText(p.getNome());
        tipos.setText(p.getTipoFraquezas());
        evolucao.setText(p.getEvoluiPara() == null ? "":p.getEvoluiPara().getNome());
    }

    public static void main(String[] args) {
        launch();
    }

}