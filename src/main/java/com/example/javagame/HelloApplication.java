package com.example.javagame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;


import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group root = createPath();
        Scene test = new Scene(root, 1280, 720);

        stage.setTitle("Regan");
        stage.setScene(test);
        stage.show();
    }

    private Group createPath() {
        Image mapImage = new Image(getClass().getResource("/images/map.png").toExternalForm());
        ImageView mapView = new ImageView(mapImage);

        Group root = new Group();
        Path minionsPath = new Path();

        MoveTo start = new MoveTo();
        start.setX(950);
        start.setY(720);

        LineTo line1 = new LineTo();
        line1.setX(950);
        line1.setY(550);

        ArcTo arc1 = new ArcTo();
        arc1.setX(850);
        arc1.setY(490);
        arc1.setRadiusX(100);
        arc1.setRadiusY(70);

        LineTo line2 = new LineTo();
        line2.setX(325);
        line2.setY(490);

        ArcTo arc2 = new ArcTo();
        arc2.setX(375);
        arc2.setY(270);
        arc2.setRadiusX(35);
        arc2.setRadiusY(35);
        arc2.setLargeArcFlag(true);
        arc2.setSweepFlag(true);

        LineTo line3 = new LineTo();
        line3.setX(795);
        line3.setY(270);

        ArcTo arc3 = new ArcTo();
        arc3.setX(860);
        arc3.setY(230);
        arc3.setRadiusX(5);
        arc3.setRadiusY(5);
        arc3.setLargeArcFlag(false);
        arc3.setSweepFlag(false);

        minionsPath.setStroke(javafx.scene.paint.Color.RED); // Set the color
        minionsPath.setStrokeWidth(3); // Set the line thickness

        minionsPath.getElements().addAll(start, line1, arc1, line2, arc2, line3, arc3);
        root.getChildren().addAll(mapView, minionsPath);
        return root;
    }

    public static void main(String[] args) {
        launch();
    }
}