package com.example.javagame;


import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;


public class PathLayer {

    private Group myRoot;
    private Path myPath;

    public PathLayer() {
        createPath();
    }

    private void createPath() {
        Image mapImage = new Image(getClass().getResource("/images/map.png").toExternalForm());
        ImageView mapView = new ImageView(mapImage);

        Group root = new Group();
        Path minionsPath = new Path();

        MoveTo start = new MoveTo(950, 720);
        LineTo line1 = new LineTo(950, 550);
        ArcTo arc1 = new ArcTo(100, 70, 0, 850, 490, false, false);
        LineTo line2 = new LineTo(325, 490);
        ArcTo arc2 = new ArcTo(35, 35, 0, 375, 270, false, true);
        LineTo line3 = new LineTo(795, 270);
        ArcTo arc3 = new ArcTo(100, 150, 0, 870, 170, false, false);
        LineTo line4 = new LineTo(870, -40);

        minionsPath.getElements().addAll(start, line1, arc1, line2, arc2, line3, arc3, line4);
        minionsPath.setStroke(javafx.scene.paint.Color.RED);
        minionsPath.setStrokeWidth(3);

        root.getChildren().addAll(mapView, minionsPath);

        myRoot = root;
        myPath = minionsPath;

    }

    public Group getRoot() {
        return myRoot;
    }

    public Path getPath() {
        return myPath;
    }


}
