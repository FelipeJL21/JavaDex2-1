/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pedro
 */
public class InterfaceGrafica extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Criando um componente (Label) da biblioteca javafx-controls
        Label label = new Label("Olá, JavaFX com Maven!");

        // Criando um layout para organizar o componente
        StackPane root = new StackPane();
        root.getChildren().add(label);

        // Criando a cena com o layout
        Scene scene = new Scene(root, 400, 250); // Largura e altura da janela

        // Configurando o palco (a janela principal)
        primaryStage.setTitle("Meu App Gráfico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
