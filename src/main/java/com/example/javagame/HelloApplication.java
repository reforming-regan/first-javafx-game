package com.example.javagame;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        PathLayer path = new PathLayer();
        Scene test = new Scene(path.getRoot(), 1280, 720);

        WaveSpawner spawner = new WaveSpawner(
                path.getRoot(),
                path.getPath(),
                List.of(
                        List.of("monster1.png", "monster1.png"), // wave 1
                        List.of("monster1.png", "monster1.png", "monster1.png") // wave 2
                ),
                Duration.seconds(0.1), // time between enemies in a wave
                Duration.seconds(8)    // time between waves
        );

        spawner.start();



        stage.setTitle("Regan");
        stage.setScene(test);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}