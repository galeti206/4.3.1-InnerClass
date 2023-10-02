package es.ieslosmontecillos.innerclass;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class InnerClass extends Application {
    @Override
    public void start(Stage primaryStage){

        BorderPane pane = new BorderPane();

        Scene scene = new Scene(pane, 320, 240);
        primaryStage.setTitle("MyCircle");
        primaryStage.setScene(scene);

        // propiedades del círculo
        myCircle.centerXProperty().bind(pane.widthProperty().divide(2));
        myCircle.centerYProperty().bind(pane.heightProperty().divide(2));
        myCircle.setRadius(50);
        myCircle.setStroke(Color.BLACK);
        myCircle.setFill(Color.WHITE);

        // Pongo el círculo en el panel central
        pane.setCenter(myCircle);

        // Botones
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");

        // Caja horizontal para los botones
        HBox box = new HBox(15, enlarge, shrink);
        pane.setBottom(box); // Pongo la caja en el panel inferior y lo ajusto al centro
        box.setAlignment(Pos.CENTER);

        enlarge.setOnAction(new EnlargeHandler());
        shrink.setOnAction(new ShrinkHandler());
        
        primaryStage.show();
    }

    // Creo la variable circulo aquí para que sea visto dentro del método start
    Circle myCircle = new Circle();

    // Método para agrandar el círculo
    public void enlarge(){
        myCircle.setRadius(myCircle.getRadius() + 5);
    }

    // Método para achicar el círculo
    public void shrink(){
        myCircle.setRadius(myCircle.getRadius() - 5);
    }

    // Acción del botón agrandar
    class EnlargeHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle (ActionEvent e){
            enlarge();
        }
    }

    // Acción del botón achicar
    class ShrinkHandler implements EventHandler<ActionEvent>{
        @Override
        public void handle (ActionEvent e){
            shrink();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}