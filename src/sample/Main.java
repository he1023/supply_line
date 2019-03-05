package sample;

import com.apple.eawt.event.RotationEvent;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.shape.StrokeLineCap;
import javafx.beans.property.*;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;


public class Main extends Application {
    double x = 0;
    double y = 0;
    // mouse position
    double orgSceneX, orgSceneY,sx,sy,ex,ey;
    double orgTranslateX, orgTranslateY;



    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));



        Group roop = new Group();
        Scene scene1=new Scene(roop,600, 600, Color.LIGHTYELLOW);

        Line x=new Line(10,420,520,420);
        Line y=new Line(10,30,10,420);
        Line supply = new Line(180, 360, 360, 180);
        supply.setStroke(Color.GREEN);
        supply.setStrokeWidth(10);
        supply.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sx=event.getSceneX();
                sy=event.getSceneY();


            }
        });
        supply.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
                orgTranslateX = ((Line)(event.getSource())).getTranslateX();
                orgTranslateY = ((Line)(event.getSource())).getTranslateY();

            }
        });
        supply.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((Line)(t.getSource())).setTranslateX(newTranslateX);
                ((Line)(t.getSource())).setTranslateY(newTranslateY);


            }
        });

        Line demand = new Line(180, 180, 360, 360);
        demand.setStroke(Color.RED);
        demand.setStrokeWidth(10);
        demand.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sx=event.getSceneX();
                sy=event.getSceneY();


            }
        });
        demand.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                orgSceneX = event.getSceneX();
                orgSceneY = event.getSceneY();
                orgTranslateX = ((Line)(event.getSource())).getTranslateX();
                orgTranslateY = ((Line)(event.getSource())).getTranslateY();
            }
        });
        demand.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                double offsetX = t.getSceneX() - orgSceneX;
                double offsetY = t.getSceneY() - orgSceneY;
                double newTranslateX = orgTranslateX + offsetX;
                double newTranslateY = orgTranslateY + offsetY;

                ((Line)(t.getSource())).setTranslateX(newTranslateX);
                ((Line)(t.getSource())).setTranslateY(newTranslateY);


            }
        });
        //Line dashX=new Line(0.0, (supply.getStartY()+demand.getStartY())/2,(supply.getEndX()+demand.getStartX())/2,(demand.getStartY()+supply.getStartY())/2);
        //Line dashy=new Line((supply.getEndX()+demand.getStartX())/2, 500,(supply.getEndX()+demand.getStartX())/2,(demand.getStartY()+supply.getStartY())/2);
        Line dashX=new Line();

        Button button1 = new Button();

        button1.setText("get price");
        button1.setLayoutX(280);
        button1.setLayoutY(510);
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Line t=new Line();
                Line price=new Line( 10,sy,sx,sy);

                price.getStrokeDashArray().setAll(1.0, 4.0);
                roop.getChildren().addAll(price);





            }
        });


        Button button2 = new Button();

        button2.setText("get quantity");
        button2.setLayoutX(410);
        button2.setLayoutY(510);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Line quantity=new Line( sx,420,sx,sy);

                quantity.getStrokeDashArray().setAll(1.0, 4.0);
                roop.getChildren().addAll(quantity);





            }
        });



            Button sp=new Button();
        Button dm=new Button();
        sp.setText("supply");
        sp.setLayoutX(20);
        sp.setLayoutY(510);
        sp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roop.getChildren().add(supply);
            }
        });


        dm.setText("demand");
        dm.setLayoutX(150);
        dm.setLayoutY(510);
        dm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                roop.getChildren().add(demand);
            }
        });

        Line a=new Line(25,500,50,500);
        Line b=new Line(150,500,175,500);
        a.setStroke(Color.GREEN);
        a.setStrokeWidth(10);
        b.setStroke(Color.RED);
        b.setStrokeWidth(10);










        roop.getChildren().addAll(x,y,button1,button2,a,b,sp,dm);
        primaryStage.setTitle("Hello World");



        primaryStage.setScene(scene1);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}